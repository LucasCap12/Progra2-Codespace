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

        while (!pila.PilaVacia()){
            System.out.println(pila.Tope());
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }

        PasarPila(aux, pila);
    }

    public static int SumarElementosPila(PilaTDA p){
        int suma = 0;
        while (!p.PilaVacia()){
            suma = suma + p.Tope();
            p.Desapilar();
        }
        return suma;

    }

}
