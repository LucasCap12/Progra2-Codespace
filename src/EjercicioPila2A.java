import algoritmos.metodosPila;
import api.PilaTDA;
import impl.PilaDinamica;

public class EjercicioPila2A {
    public static void main(String[] args) throws Exception {
        PilaTDA p1 = new PilaDinamica();
        p1.InicializarPila();
        p1.Apilar(1);
        p1.Apilar(2);
        p1.Apilar(3);

        PilaTDA p2 = new PilaDinamica();
        p2.InicializarPila();

        metodosPila.CopiarPila(p1, p2);

        System.out.println("Pila 1");
        metodosPila.MostrarPila(p1);
        System.out.println("Pila 2");
        metodosPila.MostrarPila(p2);
    }
}
