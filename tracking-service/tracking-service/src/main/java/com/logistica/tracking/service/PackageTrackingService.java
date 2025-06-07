package com.logistica.tracking.service;

import com.logistica.tracking.model.response.GetTrackingStatusResponse;

public interface PackageTrackingService {
    GetTrackingStatusResponse getTrackingStatus(String trackingNumber);
}