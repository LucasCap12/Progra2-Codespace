package algoritmos;

import api.PilaTDA;
import impl.PilaDinamica;

public class metodosPila {

    public static void PasarPila (PilaTDA p1, PilaTDA p2) {
        while (!p1.PilaVacia()) {
            p2.Apilar(p1.Tope());
            p1.Desapilar();
        }

    }
    public static void CopiarPila(PilaTDA p1, PilaTDA p2){
        /* Coopia en el mismo orden */

        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();

        PasarPila(p1, aux);

        while (!aux.PilaVacia()){
            p1.Apilar(aux.Tope());
            p2.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }
    public static void MostrarPila(PilaTDA pila){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
    }

}
