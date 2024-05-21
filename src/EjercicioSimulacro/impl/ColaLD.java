package EjercicioSimulacro.impl;

import EjercicioSimulacro.api.ColaTDA;

public class ColaLD implements ColaTDA {

    private class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo primero;
    private Nodo ultimo;

    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void Acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        if (ultimo != null)
            ultimo.sig = aux;
        ultimo = aux;
        if (primero == null)
            primero = ultimo;
    }

    @Override
    public void Desacolar() {
        if (primero != null) {
            primero = primero.sig;
            if (primero == null)
                ultimo = null;
        }
    }

    @Override
    public boolean ColaVacia() {
        return primero == null;
    }

    @Override
    public int Primero() {
        return primero.info;
    }
}
