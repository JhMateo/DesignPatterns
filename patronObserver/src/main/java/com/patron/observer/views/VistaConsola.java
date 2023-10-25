package com.patron.observer.views;

import com.patron.observer.implementation.Observador;

public class VistaConsola implements Observador {
    @Override
    public void actualizar(String estado) {
        System.out.println(estado);
    }
}