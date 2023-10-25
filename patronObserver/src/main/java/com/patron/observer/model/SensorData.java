package com.patron.observer.model;

import java.util.UUID;

public class SensorData {
    private String id;
    private String data;

    // Getters y setters para id y data

    public SensorData() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    public void setData(String data) {
        this.data = data;
    }
}
