package method;

import api.PilaTDA;
import impl.PilaDinamica;

public class CopiarPila {
    public static void CopiaPila(PilaTDA p1, PilaTDA p2){}
    PilaTDA aux = new PilaDinamica();
    while (!p1.PilaVacia())
        aux.Apilar(p1.Tope());
        p2.Apilar(p1.Tope());
        p1.Desapilar();
    
    while (!aux.PilaVacia())
        p1.Apilar(aux.Tope());
    }


}