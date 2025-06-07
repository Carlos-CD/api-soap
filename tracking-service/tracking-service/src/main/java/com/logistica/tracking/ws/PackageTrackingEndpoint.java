package com.logistica.tracking.ws;

import com.logistica.tracking.model.exception.PackageNotFoundException;
import com.logistica.tracking.model.request.GetTrackingStatusRequest;
import com.logistica.tracking.model.response.GetTrackingStatusResponse;
import com.logistica.tracking.model.response.TrackingEvent;
import com.logistica.tracking.service.PackageTrackingService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Endpoint
public class PackageTrackingEndpoint {

    private static final String NAMESPACE_URI = "http://logistica.com/ws/tracking";

    private final PackageTrackingService packageTrackingService;

    public PackageTrackingEndpoint(PackageTrackingService packageTrackingService) {
        this.packageTrackingService = packageTrackingService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTrackingStatusRequest")
    @ResponsePayload
    public GetTrackingStatusResponse getTrackingStatus(@RequestPayload GetTrackingStatusRequest request) {
        return packageTrackingService.getTrackingStatus(request.getTrackingNumber());
    }
}