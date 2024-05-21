package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

/*
la implementaci´on lista de adyacencia. La idea es tener una lista
encadenada de nodos (a los que llamaremos NodoGrafo). Cada nodo tiene
su valor, una referencia al pr´oximo nodo y adem´as una referencia a la
lista de aristas que tienen a ese nodo como origen. Una arista (a la que
llamaremos NodoArista), tiene una referencia al nodo destino de esta
arista, el peso y una referencia a la pr´oxima arista de esalista. 
*/

public class GrafoLA implements GrafoTDA {

    NodoGrafo origen;

    public void InicializarGrafo(){
        origen = null;
    }

    public void AgregarVertice(int v){
        //el vertice se interta al inicio de la lista de nodos
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    /*
     * Para agregar una nueva arista al grafo, primero se deben buscar
     * los nodos entre los cuales se va agregar la arista, y luego se
     * inserta sobre la lista de adyacentes del nodo origen (en este
     * caso nombrado como v1)
     */

    public void AgregarArista(int v1, int v2, int peso){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoGrafo n2 = Vert2Nodo(v2);

        //La nueva arista se inserta al inicio de la lista
        //de nodos adyacentes del nodo origen
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private NodoGrafo Vert2Nodo(int v){
        NodoGrafo aux = origen;
        while (aux!=null && aux.nodo !=v){
            aux = aux.sigNodo;
        }
        return aux;
    }

    public void EliminarVertice(int v){
        //Se recorre la lista de vertices para remover el nodo v
        //y las aristas con este vertice.

        //Distingue el caso que sea el primer nodo
        if(origen.nodo ==v){
            origen = origen.sigNodo;
        }

        NodoGrafo aux = origen;
        while (aux != null){
            //remueve de aux todas las aristas hacia v
            this.EliminarAristaNodo(aux, v);

            if (aux.sigNodo !=null && aux.sigNodo.nodo == v){
                //Si el siguiente nodo de aux es v, lo elimina
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }

    }

    /*
     * Si en las aristas del nodo existe
     * una arista hacia v, la elimina
     */

    private void EliminarAristaNodo (NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;

        if (aux!=null){
            //Si la arista a eliminar es la primera en
            //la lista de nodos adyacentes
            if (aux.nodoDestino.nodo == v){
                nodo.arista = aux.sigArista;
            }
            else {
                while (aux.sigArista!=null && aux.sigArista.nodoDestino.nodo != v){
                    aux = aux.sigArista;
                }
                if (aux.sigArista!=null){
                    //Quita la referencia a la arista hacia v
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    public ConjuntoTDA Vertices(){
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoGrafo aux = origen;
        while (aux != null){
            c.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return c;
        
    }

    /*
     * Se elimina la arista que tiene como origen al vertice v1
     * y destino al vertice v2
     */
    public void EliminarArista(int v1, int v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1, v2);
    }

    public boolean ExistenArista(int v1, int v2){
        NodoGrafo n1 = Vert2Nodo(v1);

        NodoArista aux = n1.arista;
        while (aux!=null && aux.nodoDestino.nodo !=v2){
            aux = aux.sigArista;
        }
        //solo si encuentra la arista buscada, aux no es null
        return aux != null;
    }

    public int PesoArista(int v1, int v2){
        NodoGrafo n1 = Vert2Nodo(v1);

        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        //Se encontró la arista entre los dos nodos
        return aux.etiqueta;
    }

}
