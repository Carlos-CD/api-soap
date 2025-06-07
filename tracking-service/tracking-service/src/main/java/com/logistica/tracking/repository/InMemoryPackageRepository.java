package com.logistica.tracking.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.logistica.tracking.model.Package;
import com.logistica.tracking.model.TrackingHistoryEvent;

@Repository
public class InMemoryPackageRepository implements PackageRepository {

    private final List<Package> packages = new ArrayList<>();

    public InMemoryPackageRepository() {
        initializeSampleData();
    }

    @Override
    public Optional<Package> findByTrackingNumber(String trackingNumber) {
        return packages.stream()
                .filter(p -> p.getTrackingNumber().equals(trackingNumber))
                .findFirst();
    }

    private void initializeSampleData() {
        Package pkg = new Package();
        pkg.setTrackingNumber("PE1234567890");
        pkg.setSenderName("Juan Pérez");
        pkg.setReceiverName("María Gómez");
        pkg.setOrigin("Arequipa");
        pkg.setDestination("Lima");
        pkg.setWeight(2.5);
        pkg.setDimensions("30x20x15");
        pkg.setStatus("En tránsito");
        pkg.setCurrentLocation("Lima, Perú");
        pkg.setEstimatedDeliveryDate(LocalDate.now().plusDays(7));
        
        List<TrackingHistoryEvent> history = new ArrayList<>();
        
        TrackingHistoryEvent event1 = new TrackingHistoryEvent();
        event1.setDateTime(LocalDateTime.now().minusDays(2));
        event1.setDescription("Paquete recibido en bodega central");
        event1.setLocation("Arequipa");
        history.add(event1);
        
        TrackingHistoryEvent event2 = new TrackingHistoryEvent();
        event2.setDateTime(LocalDateTime.now().minusDays(1));
        event2.setDescription("Salida hacia Lima");
        event2.setLocation("Arequipa");
        history.add(event2);
        
        pkg.setHistory(history);
        packages.add(pkg);
    }
}