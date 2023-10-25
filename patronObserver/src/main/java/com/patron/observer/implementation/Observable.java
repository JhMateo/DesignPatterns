package com.patron.observer.implementation;

public interface Observable {
    void notificar();
    void adicionarObservador(Observador observador);
    void removerObservador(Observador observador);
}