package com.patron.observer.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class SensorData {
    private String id;
    private double temperature;
    private double humidity;
    private double pressure;
    private LocalDateTime observationDate;

    // Getters y setters para id y data

    public SensorData() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDateTime getObservationDate() {
        return observationDate;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setObservationDate(LocalDateTime observationDate) {
        this.observationDate = observationDate;
    }
}
