package impl;

import api.PilaLimitadaTDA;

public class PilaLimitadaEstatica implements PilaLimitadaTDA {
    private int[] elementos;
    private int indice;
    private int maxTam;

    @Override
    public void InicializarPila(int maxTam) {
        this.maxTam = maxTam;
        elementos = new int[maxTam];
        indice = 0;
    }

    @Override
    public void Apilar(int x) {
        if (indice < maxTam) {
            elementos[indice] = x;
            indice++;
        } else {
            for (int i = 1; i < maxTam; i++) {
                elementos[i - 1] = elementos[i];
            }
            elementos[maxTam - 1] = x;
        }
    }

    @Override
    public void Desapilar() {
        if (indice > 0) {
            indice--;
        }
    }

    @Override
    public boolean PilaVacia() {
        return indice == 0;
    }

    @Override
    public int Tope() {
        return elementos[indice - 1];
    }
}
