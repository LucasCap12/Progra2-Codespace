package impl;

import api.ConjuntoTDA;

/*Para implementar el conjunto, a diferencia de las otras estructuras, no hay orden,
por lo tanto la estrategia es simplemente mantener la cadena de nodos y siempre
se deber´a recorrerla para buscar un elemento o eliminarlo. */

public class ConjuntoLD implements ConjuntoTDA{

    NodoCursada c;

    public void InicializarConjunto() {
        c = null;
    }

    public boolean ConjuntoVacio() {
        return (c == null);
    }

    public void Agregar(int x) {
        /*Verifica que x no este en el conjunto */
        if (!this.Pertenece(x)){
            NodoCursada aux = new NodoCursada();
            aux.info = x;
            aux.sig = c;
            c = aux;
        }
    }

    public int Elegir() {
        return c.info;
    }

    public void Sacar(int x){
        if (c!= null){
            /* si es el primer elemento de la lista */
            if (c.info == x){
                c = c.sig;
            }else{
                NodoCursada aux = c;
                while (aux.sig!=null && aux.sig.info != x)
                    aux = aux.sig;
                if (aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    public boolean Pertenece(int x) {
        NodoCursada aux = c;
        while ((aux != null) && (aux.info != x)){
            aux = aux.sig;
        }
        return (aux != null);
    }

}
