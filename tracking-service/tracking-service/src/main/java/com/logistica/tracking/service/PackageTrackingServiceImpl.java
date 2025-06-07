package com.logistica.tracking.service;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.logistica.tracking.model.exception.PackageNotFoundException;
import com.logistica.tracking.model.response.GetTrackingStatusResponse;
import com.logistica.tracking.model.response.TrackingEvent;
import com.logistica.tracking.repository.PackageRepository;

@Service
public class PackageTrackingServiceImpl implements PackageTrackingService {

    private final PackageRepository packageRepository;

    public PackageTrackingServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public GetTrackingStatusResponse getTrackingStatus(String trackingNumber) {
        return packageRepository.findByTrackingNumber(trackingNumber)
                .map(pkg -> {
                    GetTrackingStatusResponse response = new GetTrackingStatusResponse();
                    response.setStatus(pkg.getStatus());
                    response.setCurrentLocation(pkg.getCurrentLocation());
                    
                    // Convertir LocalDate a Date
                    if (pkg.getEstimatedDeliveryDate() != null) {
                        response.setEstimatedDeliveryDate(
                            Date.from(pkg.getEstimatedDeliveryDate()
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant()));
                    }
                    
                    // Convertir TrackingHistoryEvent a TrackingEvent
                    if (pkg.getHistory() != null) {
                        pkg.getHistory().forEach(event -> {
                            TrackingEvent trackingEvent = new TrackingEvent();
                            trackingEvent.setDate(
                                Date.from(event.getDateTime()
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant()));
                            trackingEvent.setDescription(event.getDescription());
                            trackingEvent.setLocation(event.getLocation());
                            response.getHistory().add(trackingEvent);
                        });
                    }
                    
                    return response;
                })
                .orElseThrow(() -> new PackageNotFoundException(trackingNumber));
    }
}