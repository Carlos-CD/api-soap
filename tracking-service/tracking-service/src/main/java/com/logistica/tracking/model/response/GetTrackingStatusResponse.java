package com.logistica.tracking.model.response;

import java.util.Date;
import java.util.List;

public class GetTrackingStatusResponse {
    private String status;
    private String currentLocation;
    private Date estimatedDeliveryDate;
    private List<TrackingEvent> history;

    // Getters
    public String getStatus() { return status; }
    public String getCurrentLocation() { return currentLocation; }
    public Date getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public List<TrackingEvent> getHistory() { return history; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; }
    public void setHistory(List<TrackingEvent> history) { this.history = history; }
}