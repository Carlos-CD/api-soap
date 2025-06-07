package com.logistica.tracking.model;

import java.time.LocalDateTime;

public class TrackingHistoryEvent {
    private LocalDateTime dateTime;
    private String description;
    private String location;

    // Getters
    public LocalDateTime getDateTime() { return dateTime; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }

    // Setters
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
}