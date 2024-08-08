
import api.PilaLimitadaTDA;
import impl.PilaLimitadaEstatica;
import impl.PilaLimitadaDinamica;

public class TestPilaLimitada {
    public static void main(String[] args) {
        PilaLimitadaTDA pilaEstatica = new PilaLimitadaEstatica();
        PilaLimitadaTDA pilaDinamica = new PilaLimitadaDinamica();

        System.out.println("Pruebas para Pila Estática:");
        probarPila(pilaEstatica);
        System.out.println("\nPruebas para Pila Dinámica:");
        probarPila(pilaDinamica);
    }

    public static void probarPila(PilaLimitadaTDA pila) {
        pila.InicializarPila(3);
        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(3);
        pila.Apilar(4);

        System.out.println("Pila después de apilar 1, 2, 3, 4:");
        mostrarPila(pila);  // Esperado: 4, 3, 2

        pila.Desapilar();
        System.out.println("Pila después de desapilar:");
        mostrarPila(pila);  // Esperado: 3, 2

        pila.Apilar(5);
        System.out.println("Pila después de apilar 5:");
        mostrarPila(pila);  // Esperado: 5, 3, 2
    }

    public static void mostrarPila(PilaLimitadaTDA pila) {
        PilaLimitadaTDA aux = clonarPila(pila);
        while (!aux.PilaVacia()) {
            System.out.println(aux.Tope());
            aux.Desapilar();
        }
    }

    public static PilaLimitadaTDA clonarPila(PilaLimitadaTDA pila) {
        PilaLimitadaTDA aux = new PilaLimitadaEstatica();  // Usar implementación estática para auxiliar
        aux.InicializarPila(3);
        PilaLimitadaTDA copia = new PilaLimitadaEstatica();  // Usar implementación estática para la copia
        copia.InicializarPila(3);

        while (!pila.PilaVacia()) {
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }

        while (!aux.PilaVacia()) {
            int tope = aux.Tope();
            pila.Apilar(tope);
            copia.Apilar(tope);
            aux.Desapilar();
        }

        return copia;
    }
}
