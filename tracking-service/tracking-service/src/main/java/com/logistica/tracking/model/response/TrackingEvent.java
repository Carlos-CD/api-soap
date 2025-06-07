package com.logistica.tracking.model.response;

import java.util.Date;

public class TrackingEvent {
    private Date date;
    private String description;
    private String location;

    // Getters
    public Date getDate() { return date; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }

    // Setters
    public void setDate(Date date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
    public void setLocation(String location) { this.location = location; }
}