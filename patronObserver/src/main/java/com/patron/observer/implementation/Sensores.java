package com.patron.observer.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sensores {
    private FuenteDeDatos fuenteDeDatos;
    private Random random = new Random();

    public Sensores(FuenteDeDatos fuenteDeDatos) {
        this.fuenteDeDatos = fuenteDeDatos;
    }

    public void generarYEnviarDatosAleatorios() {
        for (int i = 0; i < 30; i++) {
            double datos = random.nextDouble() * 100; // Datos aleatorios
            fuenteDeDatos.establecerEstado("Datos generados por Sensores: " + datos);
            // Pausa de 2 segundos
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("La pausa fue interrumpida: " + e.getMessage());
            }
        }
    }
}