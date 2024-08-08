package impl;

import api.PilaTDA;

public class PilaDinamica implements PilaTDA{
    NodoCursada primero;

    @Override
    public void InicializarPila() {
        primero = null;
    }

    @Override
    public void Apilar(int x) {
        NodoCursada aux = new NodoCursada();
        aux.info = x;
        aux.sig = primero;
        primero = aux;
    }

    @Override
    public void Desapilar() {
        primero = primero.sig;
    }

    @Override
    public boolean PilaVacia() {
        return(primero == null);
    }

    @Override
    public int Tope() {
        return(primero.info);
    }

}
