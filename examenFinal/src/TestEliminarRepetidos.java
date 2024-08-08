import api.ColaTDA;
import impl.ColaLD;
import algoritmos.EliminarRepetidos;

public class TestEliminarRepetidos {
    public static void main(String[] args) {
        ColaTDA colaOriginal = new ColaLD();
        colaOriginal.InicializarCola();
        
        colaOriginal.Acolar(1);
        colaOriginal.Acolar(2);
        colaOriginal.Acolar(1);
        colaOriginal.Acolar(3);
        colaOriginal.Acolar(2);
        colaOriginal.Acolar(4);

        System.out.println("Cola original:");
        MostrarCola(colaOriginal);

        ColaTDA colaSinRepetidos = EliminarRepetidos.eliminarRepetidos(colaOriginal);

        System.out.println("Cola sin repetidos:");
        MostrarCola(colaSinRepetidos);
    }

    public static void MostrarCola(ColaTDA cola) {
        ColaTDA aux = new ColaLD();
        aux.InicializarCola();

        while (!cola.ColaVacia()) {
            int elemento = cola.Primero();
            System.out.print(elemento + " ");
            aux.Acolar(elemento);
            cola.Desacolar();
        }
        System.out.println();

        // Restaurar la cola original
        while (!aux.ColaVacia()) {
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }
}
