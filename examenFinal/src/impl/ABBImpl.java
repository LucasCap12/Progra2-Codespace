package impl;

import api.ABBTDA;

public class ABBImpl implements ABBTDA {
    private class NodoABB {
        int valor;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }

    private NodoABB raiz;

    @Override
    public void InicializarArbol() {
        raiz = null;
    }

    @Override
    public void AgregarElemento(int x) {
        if (raiz == null) {
            raiz = new NodoABB();
            raiz.valor = x;
            raiz.hijoIzq = new ABBImpl();
            raiz.hijoDer = new ABBImpl();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer.InicializarArbol();
        } else if (x < raiz.valor) {
            raiz.hijoIzq.AgregarElemento(x);
        } else {
            raiz.hijoDer.AgregarElemento(x);
        }
    }

    @Override
    public void EliminarElemento(int x) {
        // Implementación de eliminación omitida por simplicidad.
    }

    @Override
    public int Raiz() {
        return raiz.valor;
    }

    @Override
    public ABBTDA HijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public ABBTDA HijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz == null;
    }
}
