package EjercicioSimulacro.impl;

import EjercicioSimulacro.api.ColaTDA;

public class ListaPromediada {
    private class NodoLista {
        int valor;
        NodoLista siguiente;

        NodoLista(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private NodoLista primero;
    private NodoLista ultimo;
    private int cantidadElementos;
    private int sumaTotal;

    // Costo temporal: O(1)
    public void inicializar() {
        primero = null;
        ultimo = null;
        cantidadElementos = 0;
        sumaTotal = 0;
    }

    // Costo temporal: O(1)
    public void agregar(int valor) {
        if (cantidadElementos == 0) {
            primero = new NodoLista(valor);
            ultimo = primero;
        } else {
            double promedio = (double) sumaTotal / cantidadElementos;
            if (valor < promedio) {
                NodoLista nuevoNodo = new NodoLista(valor);
                nuevoNodo.siguiente = primero;
                primero = nuevoNodo;
            } else if (valor > promedio) {
                ultimo.siguiente = new NodoLista(valor);
                ultimo = ultimo.siguiente;
            } else {
                // Si el valor es igual al promedio, no se ingresa
                return;
            }
        }
        cantidadElementos++;
        sumaTotal += valor;
    }

    // Costo temporal: O(n)
    public void eliminar(int valor) {
        NodoLista anterior = null;
        NodoLista actual = primero;

        while (actual != null) {
            if (actual.valor == valor) {
                if (anterior == null) {
                    primero = actual.siguiente;
                    if (primero == null) {
                        ultimo = null;
                    }
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual.siguiente == null) {
                        ultimo = anterior;
                    }
                }
                cantidadElementos--;
                sumaTotal -= valor;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Costo temporal: O(1)
    public double promedio() {
        if (cantidadElementos == 0) {
            return 0; // Evitar división por cero
        }
        return (double) sumaTotal / cantidadElementos;
    }

    // Costo temporal: O(n)
    public ColaTDA menores() {
        ColaTDA menores = new ColaLD();
        menores.InicializarCola();
        double promedio = promedio();

        NodoLista actual = primero;
        while (actual != null) {
            if (actual.valor < promedio) {
                menores.Acolar(actual.valor);
            }
            actual = actual.siguiente;
        }

        return menores;
    }

    // Costo temporal: O(n)
    public ColaTDA mayores() {
        ColaTDA mayores = new ColaLD();
        mayores.InicializarCola();
        double promedio = promedio();

        NodoLista actual = primero;
        while (actual != null) {
            if (actual.valor > promedio) {
                mayores.Acolar(actual.valor);
            }
            actual = actual.siguiente;
        }

        return mayores;
    }

    // Costo temporal: O(1)
    public boolean estaVacia() {
        return cantidadElementos == 0;
    }
}
