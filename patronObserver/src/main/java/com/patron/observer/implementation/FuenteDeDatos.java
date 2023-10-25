package com.patron.observer.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FuenteDeDatos implements Observable {
    private Map<String, Double> estado;
    private List<Observador> listadoObservadores = new ArrayList<>();

    public Map<String, Double> obtenerEstado() {
        return estado;
    }

    public void establecerEstado(Map<String, Double> nuevoEstado) {
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