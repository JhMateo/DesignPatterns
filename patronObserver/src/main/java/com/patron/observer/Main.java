package com.patron.observer;

import com.patron.observer.implementation.FuenteDeDatos;
import com.patron.observer.implementation.Observador;
import com.patron.observer.implementation.Sensores;
import com.patron.observer.views.VistaArchivo;
import com.patron.observer.views.VistaConsola;
import com.patron.observer.views.VistaBaseDatos;

public class Main {
    public static void main(String[] args) {

        // Crear instancia de FuenteDeDatos
        FuenteDeDatos fuenteDeDatos = new FuenteDeDatos();

        // Crear observadores
        Observador vistaConsola = new VistaConsola();
        Observador vistaBaseDatos = new VistaBaseDatos();
        Observador vistaArchivo = new VistaArchivo("datosSensor");

        // Registrar observadores en FuenteDeDatos
        fuenteDeDatos.adicionarObservador(vistaConsola);
        fuenteDeDatos.adicionarObservador(vistaBaseDatos);
        fuenteDeDatos.adicionarObservador(vistaArchivo);

        // Crear instancia de Sensores y enviar datos
        Sensores sensores = new Sensores(fuenteDeDatos);
        sensores.generarYEnviarDatosAleatorios();
    }
}