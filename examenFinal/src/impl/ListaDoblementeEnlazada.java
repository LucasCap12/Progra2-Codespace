package impl;

import api.ListaDoblementeEnlazadasTDA;

public class ListaDoblementeEnlazada implements ListaDoblementeEnlazadasTDA {
    private Nodo cabeza;
    private Nodo cola;

    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
    }

    // 1. Método para agregar un valor a la lista
    public void Agregar(int num) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = num;
        if (cabeza == null) { // Lista vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.sig = nuevoNodo;
            nuevoNodo.prev = cola;
            cola = nuevoNodo;
        }
    }

    // 2. Método para eliminar la primera ocurrencia de un valor
    public void Eliminar(int num) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.valor == num) {
                if (actual.prev != null) {
                    actual.prev.sig = actual.sig;
                } else {
                    cabeza = actual.sig;
                }
                if (actual.sig != null) {
                    actual.sig.prev = actual.prev;
                } else {
                    cola = actual.prev;
                }
                return;
            }
            actual = actual.sig;
        }
    }

    // 3. Método para eliminar todas las ocurrencias de un valor
    public void EliminarTodos(int num) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.valor == num) {
                if (actual.prev != null) {
                    actual.prev.sig = actual.sig;
                } else {
                    cabeza = actual.sig;
                }
                if (actual.sig != null) {
                    actual.sig.prev = actual.prev;
                } else {
                    cola = actual.prev;
                }
            }
            actual = actual.sig;
        }
    }

    // 4. Método para mostrar la lista desde la cabeza hasta la cola
    public void MostrarCabezaCola() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.sig;
        }
        System.out.println();
    }

    // 4. Método para mostrar la lista desde la cola hasta la cabeza
    public void MostrarColaCabeza() {
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.prev;
        }
        System.out.println();
    }
}
