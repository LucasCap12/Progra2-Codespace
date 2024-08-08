import api.PilaTDA;
import api.DiccionarioSimpleTDA;
import api.ConjuntoTDA;
import impl.PilaDinamica;
import algoritmos.ElementosPilaADiccionario;

public class TestElementosPilaADiccionario {
    public static void main(String[] args) {
        PilaTDA pila = new PilaDinamica();
        pila.InicializarPila();
        
        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(1);
        pila.Apilar(3);
        pila.Apilar(2);
        pila.Apilar(4);
        pila.Apilar(1);

        DiccionarioSimpleTDA diccionario = ElementosPilaADiccionario.convertirPilaADiccionario(pila);

        System.out.println("Diccionario de elementos de la pila:");
        MostrarDiccionario(diccionario);
    }

    public static void MostrarDiccionario(DiccionarioSimpleTDA diccionario) {
        ConjuntoTDA claves = diccionario.Claves();
        while (!claves.ConjuntoVacio()) {
            int clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.println("Clave: " + clave + ", Valor: " + diccionario.Recuperar(clave));
        }
    }
}
