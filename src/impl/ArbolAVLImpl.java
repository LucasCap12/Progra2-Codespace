//Implementacion
package impl;

import api.ArbolAVL;

public class ArbolAVLImpl implements ArbolAVL {
    private class Nodo {
        int dato;
        Nodo izquierdo;
        Nodo derecho;
        int altura;

        Nodo(int dato) {
            this.dato = dato;
            this.altura = 1;
        }
    }

    private Nodo raiz;

    @Override
    public void InicializarArbol() {
        raiz = null;
    }

    @Override
    public void Insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo nodo, int dato) {
        // Inserción estándar en un árbol binario de búsqueda
        if (nodo == null) {
            return new Nodo(dato);
        }
        if (dato < nodo.dato) {
            nodo.izquierdo = insertar(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertar(nodo.derecho, dato);
        } else {
            return nodo; // No se permiten duplicados
        }

        // Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Obtener el balance del nodo actual
        int balance = obtenerBalance(nodo);

        // Rotaciones para mantener el balance AVL

        // Caso 1: Desbalanceo hacia la izquierda-izquierda
        if (balance > 1 && dato < nodo.izquierdo.dato) {
            return rotarDerecha(nodo);
        }

        // Caso 2: Desbalanceo hacia la derecha-derecha
        if (balance < -1 && dato > nodo.derecho.dato) {
            return rotarIzquierda(nodo);
        }

        // Caso 3: Desbalanceo hacia la izquierda-derecha
        if (balance > 1 && dato > nodo.izquierdo.dato) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Caso 4: Desbalanceo hacia la derecha-izquierda
        if (balance < -1 && dato < nodo.derecho.dato) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    @Override
    public void Eliminar(int x) {
        raiz = eliminar(raiz, x);
    }

    private Nodo eliminar(Nodo nodo, int dato) {
        // Eliminación estándar en un árbol binario de búsqueda
        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.dato) {
            nodo.izquierdo = eliminar(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = eliminar(nodo.derecho, dato);
        } else {
            // Nodo con uno o ningún hijo
            if ((nodo.izquierdo == null) || (nodo.derecho == null)) {
                Nodo temp = nodo.izquierdo != null ? nodo.izquierdo : nodo.derecho;

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor
                Nodo temp = obtenerMinimo(nodo.derecho);

                nodo.dato = temp.dato;

                nodo.derecho = eliminar(nodo.derecho, temp.dato);
            }
        }

        if (nodo == null) {
            return nodo;
        }

        // Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Obtener el balance del nodo actual
        int balance = obtenerBalance(nodo);

        // Rotaciones para mantener el balance AVL

        // Caso 1: Desbalanceo hacia la izquierda-izquierda
        if (balance > 1 && obtenerBalance(nodo.izquierdo) >= 0) {
            return rotarDerecha(nodo);
        }

        // Caso 2: Desbalanceo hacia la izquierda-derecha
        if (balance > 1 && obtenerBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Caso 3: Desbalanceo hacia la derecha-derecha
        if (balance < -1 && obtenerBalance(nodo.derecho) <= 0) {
            return rotarIzquierda(nodo);
        }

        // Caso 4: Desbalanceo hacia la derecha-izquierda
        if (balance < -1 && obtenerBalance(nodo.derecho) > 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    @Override
    public int Raiz() {
        if (raiz != null) {
            return raiz.dato;
        }
        return -1; // Indica que el árbol está vacío
    }

    @Override
    public ArbolAVL HijoIzq() {
        ArbolAVLImpl subArbolIzq = new ArbolAVLImpl();
        subArbolIzq.raiz = raiz != null ? raiz.izquierdo : null;
        return subArbolIzq;
    }

    @Override
    public ArbolAVL HijoDer() {
        ArbolAVLImpl subArbolDer = new ArbolAVLImpl();
        subArbolDer.raiz = raiz != null ? raiz.derecho : null;
        return subArbolDer;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz == null;
    }

    // Métodos auxiliares

    // Devuelve la altura de un nodo
    private int altura(Nodo nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    // Devuelve el factor de balance de un nodo
    private int obtenerBalance(Nodo nodo) {
        return nodo == null ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Realiza una rotación a la derecha en el subárbol enraizado con y
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        // Realizar rotación
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    // Realiza una rotación a la izquierda en el subárbol enraizado con x
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        // Realizar rotación
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    // Encuentra el nodo con el valor mínimo en el subárbol enraizado con nodo
    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
}
