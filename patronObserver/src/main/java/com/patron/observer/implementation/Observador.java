package com.patron.observer.implementation;

import com.patron.observer.model.SensorData;

import java.util.Map;

public interface Observador {
    void actualizar(Map<String, SensorData> estado);
}