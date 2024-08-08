package algoritmos;

import api.ColaTDA;
import impl.ColaLD;
import impl.ConjuntoLD;

public class EliminarRepetidos {

    public static ColaTDA eliminarRepetidos(ColaTDA colaOriginal) {
        ColaTDA colaNueva = new ColaLD();
        colaNueva.InicializarCola();

        ConjuntoLD elementosVistos = new ConjuntoLD();
        elementosVistos.InicializarConjunto();

        while (!colaOriginal.ColaVacia()) {
            int elemento = colaOriginal.Primero();
            colaOriginal.Desacolar();
            if (!elementosVistos.Pertenece(elemento)) {
                elementosVistos.Agregar(elemento);
                colaNueva.Acolar(elemento);
            }
        }
        return colaNueva;
    }

}
