package com.patron.observer.implementation;

import com.patron.observer.implementation.Observable;
import com.patron.observer.implementation.Observador;

import java.util.ArrayList;
import java.util.List;

public class FuenteDeDatos implements Observable {
    private String estado;
    private List<Observador> listadoObservadores = new ArrayList<>();

    public String obtenerEstado() {
        return estado;
    }

    public void establecerEstado(String nuevoEstado) {
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