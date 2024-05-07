package impl;

import api.SecuenciaTDA;

public class SecuenciaDinamica implements SecuenciaTDA {
    Nodo inicio;
    int tamaño;

    public void InicializarSecuencia() {
        inicio = null;
        tamaño = 0;
    }

    public void AgregarEnPos(int x, int p) {
        if (p >= 0 && p < tamaño) {
            Nodo actual = inicio;
            for (int i = 0; i < p; i++) {
                actual = actual.sig;
            }
            actual.info = x;
        }
    }

    public void AgregarAlInicio(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = inicio;
        inicio = nuevo;
        tamaño++;
    }

    public void AgregarAlFinal(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;
        }
        tamaño++;
    }

    public void InsertarEnPos(int x, int p) {
        if (p >= 0 && p <= tamaño) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (p == 0) {
                nuevo.sig = inicio;
                inicio = nuevo;
            } else {
                Nodo anterior = null;
                Nodo actual = inicio;
                for (int i = 0; i < p; i++) {
                    anterior = actual;
                    actual = actual.sig;
                }
                nuevo.sig = actual;
                anterior.sig = nuevo;
            }
            tamaño++;
        }
    }

    public void EliminarPos(int p) {
        if (p >= 0 && p < tamaño) {
            if (p == 0) {
                inicio = inicio.sig;
            } else {
                Nodo anterior = inicio;
                for (int i = 1; i < p; i++) {
                    anterior = anterior.sig;
                }
                anterior.sig = anterior.sig.sig;
            }
            tamaño--;
        }
    }

    public void EliminarTodosValor(int x) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null) {
            if (actual.info == x) {
                if (anterior == null) {
                    inicio = actual.sig;
                } else {
                    anterior.sig = actual.sig;
                }
                tamaño--;
            } else {
                anterior = actual;
            }
            actual = actual.sig;
        }
    }

    public void Ordenar() {
        if (tamaño > 1) {
            Nodo actual = inicio.sig;

            while (actual != null) {
                int valor = actual.info;
                Nodo aux = inicio;

                while (aux != actual && aux.info <= valor) {
                    aux = aux.sig;
                }

                while (aux != actual) {
                    int aux2 = aux.info;
                    aux.info = valor;
                    valor = aux2;
                    aux = aux.sig;
                }

                aux.info = valor;

                actual = actual.sig;
            }
        }
    }

    public void Mostrar() {
        Nodo actual = inicio;
        System.out.print("Secuencia: ");
        while (actual != null) {
            System.out.print(actual.info + " ");
            actual = actual.sig;
        }
        System.out.println();
    }

    public boolean SecuenciaVacia() {
        return (inicio == null);
    }
}
