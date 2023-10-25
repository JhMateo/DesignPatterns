package com.patron.observer.implementation;

import java.util.Map;

public interface Observador {
    void actualizar(Map<String, Double> estado);
}