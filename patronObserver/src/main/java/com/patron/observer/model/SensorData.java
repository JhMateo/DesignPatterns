package com.patron.observer.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SensorData {
    private final String id;
    private double temperature;
    private double humidity;
    private double pressure;
    private LocalDateTime observationDate;

    public SensorData() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    // Getters y setters para id y data
    public String getId() {
        return id;
    }

    public double obtenerHumedad() {
        return humidity;
    }

    public double obtenerPresion() {
        return pressure;
    }

    public double obtenerTemperatura() {
        return temperature;
    }

    public Map<String, Double> getData() {
        Map<String, Double> dataMap = new HashMap<>();
        dataMap.put("Humidity", humidity);
        dataMap.put("Pressure", pressure);
        dataMap.put("Temperature", temperature);

        return dataMap;
    }

    public LocalDateTime obtenerObservacionFecha() {
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
