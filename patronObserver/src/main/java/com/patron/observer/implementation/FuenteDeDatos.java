package com.patron.observer.implementation;

import com.patron.observer.model.SensorData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FuenteDeDatos implements Observable {
    private SensorData estado;
    private List<Observador> listadoObservadores = new ArrayList<>();

    public SensorData obtenerEstado() {
        return estado;
    }

    public void establecerEstado(SensorData nuevoEstado) {
        estado = nuevoEstado;
        notificar();
    }

    @Override
    public void notificar() {
        for (Observador observador : listadoObservadores) {
            observador.actualizar(estado);
        }
    }

    @Override
    public void adicionarObservador(Observador observador) {
        listadoObservadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        listadoObservadores.remove(observador);
    }
}