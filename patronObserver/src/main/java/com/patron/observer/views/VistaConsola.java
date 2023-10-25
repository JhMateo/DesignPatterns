package com.patron.observer.views;

import com.patron.observer.implementation.Observador;

import java.util.Map;

public class VistaConsola implements Observador {
    @Override
    public void actualizar(Map<String, Double> estado) {
        System.out.println("\nDatos recibidos:");
        for (Map.Entry<String, Double> entry : estado.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}