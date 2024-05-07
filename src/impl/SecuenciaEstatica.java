package impl;

import api.SecuenciaTDA;

public class SecuenciaEstatica implements SecuenciaTDA {
    int[] elementos; // Arreglo para almacenar los elementos
    int tamaño; // Tamaño actual de la secuencia
    
    public void InicializarSecuencia() {
        elementos = new int[100];
        tamaño = 0;
    }
    
    public void AgregarEnPos(int x, int p) {
        if (p >= 0 && p < tamaño) {
            elementos[p] = x;
        }
    }
    
    
    public void AgregarAlInicio(int x) {
        AgregarEnPos(x, 0);
    }
    
    public void AgregarAlFinal(int x) {
        elementos[tamaño] = x;
        tamaño++;
    }
    
    public void InsertarEnPos(int x, int p) {
        if (p >= 0 && p <= tamaño) {
            for (int i = tamaño; i > p; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[p] = x;
            tamaño++;
        }
    }
    
    public void EliminarPos(int p) {
        if (p >= 0 && p < tamaño) {
            for (int i = p; i < tamaño - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            tamaño--;
        }
    }
    
    public void EliminarTodosValor(int x) {
        int i = 0;
        while (i < tamaño) {
            if (elementos[i] == x) {
                EliminarPos(i);
            } else {
                i++;
            }
        }
    }
    
    public void Ordenar() { //Burbujeo
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 0; j < tamaño - i - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    int temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }
    
    
    public void Mostrar() {
        System.out.print("Secuencia: ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
    
    public boolean SecuenciaVacia() {
        return (tamaño == 0);
    }
}
