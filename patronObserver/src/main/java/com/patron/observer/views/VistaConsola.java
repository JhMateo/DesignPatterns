package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;

public class VistaConsola implements Observador {
    @Override
    public void actualizar(SensorData estado) {
        System.out.println("\nDatos recibidos:");

        System.out.println("Id: " + estado.getId());
        System.out.println("Temperatura: " + estado.obtenerTemperatura());
        System.out.println("Humedad: " + estado.obtenerHumedad());
        System.out.println("Presión: " + estado.obtenerPresion());
        System.out.println("Fecha de Observación: " + estado.obtenerObservacionFecha());
        System.out.println();
    }
}