package method;

import api.PilaTDA;

public class PasarPila {
    public static void PasaPila(PilaTDA p1, PilaTDA p2){
        while (!p1.PilaVacia())
            p2.Apilar(p1.Tope());
            p1.Desapilar();

}
}