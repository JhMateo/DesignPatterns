package com.patron.observer;

import com.patron.observer.implementation.FuenteDeDatos;
import com.patron.observer.implementation.Observador;
import com.patron.observer.implementation.Sensores;
import com.patron.observer.views.*;

public class Main {
    public static void main(String[] args) {

        // Crear instancia de FuenteDeDatos
        FuenteDeDatos fuenteDeDatos = new FuenteDeDatos();

        // Crear observadores
        Observador vistaConsola = new VistaConsola();
        Observador vistaBaseDatos = new VistaBaseDatos();
        Observador vistaArchivo = new VistaArchivo("datosSensor");
        Observador vistaGrafica = new GraphReport();
        Observador vistaTabla = new TableReport();

        // Registrar observadores en FuenteDeDatos
        fuenteDeDatos.adicionarObservador(vistaConsola);
        fuenteDeDatos.adicionarObservador(vistaBaseDatos);
        fuenteDeDatos.adicionarObservador(vistaArchivo);
        fuenteDeDatos.adicionarObservador(vistaGrafica);
        fuenteDeDatos.adicionarObservador(vistaTabla);

        // Crear instancia de Sensores y enviar datos
        Sensores sensores = new Sensores(fuenteDeDatos);
        sensores.generarYEnviarDatosAleatorios();
    }
}