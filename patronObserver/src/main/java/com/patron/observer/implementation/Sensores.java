package com.patron.observer.implementation;

import java.util.HashMap;
import java.util.Map;
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
            Map<String, Double> datos = new HashMap<>();
            datos.put("Temperature", 20 + random.nextDouble() * random.nextInt(1, 10));
            datos.put("Humidity", 40 + random.nextDouble() * random.nextInt(1, 20));
            datos.put("Pressure", 900 + random.nextDouble() * random.nextInt(1, 100));

            fuenteDeDatos.establecerEstado(datos);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("La pausa fue interrumpida: " + e.getMessage());
            }
        }
    }
}