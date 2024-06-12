//EjemploImplementacionArbolAVL
import impl.ArbolAVLImpl;
import api.ArbolAVL;

public class EjercicioArbolAVL {

    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVLImpl();
        arbol.InicializarArbol();

        int[] elementosAInsertar = {10, 30, 20, 40, 50, 25, 15, 60};
        for (int elemento : elementosAInsertar) {
            arbol.Insertar(elemento);
            System.out.println("Insertado: " + elemento);
            mostrarArbol(arbol);
        }

        System.out.println("Eliminado: 20");
        arbol.Eliminar(20);
        mostrarArbol(arbol);

        System.out.println("Eliminado: 25");
        arbol.Eliminar(25);
        mostrarArbol(arbol);

        System.out.println("Árbol AVL final:");
        mostrarArbol(arbol);
    }

    private static void mostrarArbol(ArbolAVL arbol) {
        mostrarArbolRecursivo(arbol);
        System.out.println();
    }

    private static void mostrarArbolRecursivo(ArbolAVL arbol) {
        if (!arbol.ArbolVacio()) {
            mostrarArbolRecursivo(arbol.HijoIzq());
            System.out.print(arbol.Raiz() + " ");
            mostrarArbolRecursivo(arbol.HijoDer());
        }
    }
}
