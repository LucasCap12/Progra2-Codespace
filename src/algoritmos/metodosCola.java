package algoritmos;

import api.ColaTDA;

public class metodosCola {

    public static void PasarCola(ColaTDA origen, ColaTDA destino){
        while (!origen.ColaVacia()){
            destino.Acolar(origen.Primero());
            destino.Desacolar();
        }
    }

}
