package com.patron.observer.views;

import com.patron.observer.implementation.Observador;
import com.patron.observer.model.SensorData;
import com.patron.observer.repository.GenericDTO;

import java.util.List;

public class VistaBaseDatos implements Observador {

    public VistaBaseDatos(){
        GenericDTO<SensorData> sensorDataDTO = new GenericDTO<>(SensorData.class, "SensorData", List.of("id"));
        sensorDataDTO.deleteAll();
    }

    @Override
    public void actualizar(String estado) {
        GenericDTO<SensorData> sensorDataDTO = new GenericDTO<>(SensorData.class, "SensorData", List.of("id"));
        SensorData sensorData = new SensorData();
        sensorData.setData(estado);
        sensorDataDTO.insert(sensorData);
    }
}
