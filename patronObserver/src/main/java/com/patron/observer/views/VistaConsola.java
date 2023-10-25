package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

import java.util.Map;

public class VistaConsola implements Observador {
    @Override
    public void actualizar(SensorData estado) {
        System.out.println("\nDatos recibidos:");

        System.out.println("Id: " + estado.getId());
        System.out.println("Temperatura: " + estado.getTemperature());
        System.out.println("Humedad: " + estado.getHumidity());
        System.out.println("Presión: " + estado.getPressure());
        System.out.println("Fecha de Observación: " + estado.getObservationDate());
        System.out.println();
    }
}