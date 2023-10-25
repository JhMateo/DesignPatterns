package com.patron.observer.model;

import java.util.UUID;

public class SensorData {
    private String id;
    private double temperature;
    private double humidity;
    private double pressure;

    // Getters y setters para id y data

    public SensorData() {
        this.id = String.valueOf(UUID.randomUUID());
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
}
