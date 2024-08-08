import api.ABBTDA;
import impl.ABBImpl;
import algoritmos.MetodosABB;
import algoritmos.MetodosABB.Resultados;

public class TestMetodosABB {
    public static void main(String[] args) {
        ABBTDA arbol = new ABBImpl();
        arbol.InicializarArbol();
        arbol.AgregarElemento(10);
        arbol.AgregarElemento(5);
        arbol.AgregarElemento(15);
        arbol.AgregarElemento(3);
        arbol.AgregarElemento(7);
        arbol.AgregarElemento(12);
        arbol.AgregarElemento(18);

        Resultados resultados = MetodosABB.calcularSumaImparesYHojasPares(arbol);

        System.out.println("Suma de elementos impares: " + resultados.sumaImpares);
        System.out.println("Cantidad de hojas con valores pares: " + resultados.cantidadHojasPares);
    }
}
