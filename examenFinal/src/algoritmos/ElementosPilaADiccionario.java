package algoritmos;

import api.PilaTDA;
import api.DiccionarioSimpleTDA;
import impl.DicSimpleL;
import impl.PilaDinamica;

public class ElementosPilaADiccionario {

    public static DiccionarioSimpleTDA convertirPilaADiccionario(PilaTDA pila) {
        DiccionarioSimpleTDA diccionario = new DicSimpleL();
        diccionario.InicializarDiccionario();

        PilaTDA pilaAux = new PilaDinamica();
        pilaAux.InicializarPila();

        while (!pila.PilaVacia()) {
            int elemento = pila.Tope();
            pila.Desapilar();
            pilaAux.Apilar(elemento);

            if (diccionario.Claves().Pertenece(elemento)) {
                diccionario.Agregar(elemento, diccionario.Recuperar(elemento) + 1);
            } else {
                diccionario.Agregar(elemento, 1);
            }
        }

        // Restaurar la pila original
        while (!pilaAux.PilaVacia()) {
            pila.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }

        return diccionario;
    }

}
