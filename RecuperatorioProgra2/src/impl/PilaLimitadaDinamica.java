package impl;

import api.PilaLimitadaTDA;

public class PilaLimitadaDinamica implements PilaLimitadaTDA {
    private class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo tope;
    private int tamaño;
    private int maxTam;

    @Override
    public void InicializarPila(int maxTam) {
        this.maxTam = maxTam;
        tope = null;
        tamaño = 0;
    }

    @Override
    public void Apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = tope;
        tope = nuevo;
        tamaño++;

        if (tamaño > maxTam) {
            Nodo actual = tope;
            for (int i = 1; i < maxTam; i++) {
                actual = actual.sig;
            }
            actual.sig = null;
            tamaño = maxTam;
        }
    }

    @Override
    public void Desapilar() {
        if (tope != null) {
            tope = tope.sig;
            tamaño--;
        }
    }

    @Override
    public boolean PilaVacia() {
        return tope == null;
    }

    @Override
    public int Tope() {
        return tope.info;
    }
}
