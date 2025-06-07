package com.logistica.tracking.model;

import java.time.LocalDate;
import java.util.List;

public class Package {
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String origin;
    private String destination;
    private double weight;
    private String dimensions;
    private String status;
    private String currentLocation;
    private LocalDate estimatedDeliveryDate;
    private List<TrackingHistoryEvent> history;

    // Getters
    public String getTrackingNumber() { return trackingNumber; }
    public String getSenderName() { return senderName; }
    public String getReceiverName() { return receiverName; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public double getWeight() { return weight; }
    public String getDimensions() { return dimensions; }
    public String getStatus() { return status; }
    public String getCurrentLocation() { return currentLocation; }
    public LocalDate getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public List<TrackingHistoryEvent> getHistory() { return history; }

    // Setters
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public void setStatus(String status) { this.status = status; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) { this.estimatedDeliveryDate = estimatedDeliveryDate; }
    public void setHistory(List<TrackingHistoryEvent> history) { this.history = history; }
}