package com.patron.observer.implementation;

import com.patron.observer.model.SensorData;


public interface Observador {
    void actualizar(SensorData estado);
}