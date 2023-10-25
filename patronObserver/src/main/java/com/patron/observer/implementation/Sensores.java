package com.patron.observer.implementation;

import com.patron.observer.model.SensorData;

import java.time.LocalDateTime;
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

        while(true){
            SensorData sensorData = new SensorData();
            sensorData.setTemperature(20 + random.nextDouble() * 10);
            sensorData.setHumidity(40 + random.nextDouble() * 20);
            sensorData.setPressure(900 + random.nextDouble() * 100);
            sensorData.setObservationDate(LocalDateTime.now());

            fuenteDeDatos.establecerEstado(sensorData);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("La pausa fue interrumpida: " + e.getMessage());
            }
        }
    }
}