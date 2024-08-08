package algoritmos;

import api.ABBTDA;

public class MetodosABB {

    public static class Resultados {
        public int sumaImpares;
        public int cantidadHojasPares;

        public Resultados(int sumaImpares, int cantidadHojasPares) {
            this.sumaImpares = sumaImpares;
            this.cantidadHojasPares = cantidadHojasPares;
        }
    }

    public static Resultados calcularSumaImparesYHojasPares(ABBTDA arbol) {
        if (arbol.ArbolVacio()) {
            return new Resultados(0, 0);
        }

        Resultados resultadosIzq = calcularSumaImparesYHojasPares(arbol.HijoIzq());
        Resultados resultadosDer = calcularSumaImparesYHojasPares(arbol.HijoDer());

        int sumaImpares = resultadosIzq.sumaImpares + resultadosDer.sumaImpares;
        int cantidadHojasPares = resultadosIzq.cantidadHojasPares + resultadosDer.cantidadHojasPares;

        int valor = arbol.Raiz();
        if (valor % 2 != 0) {
            sumaImpares += valor;
        }

        if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio() && valor % 2 == 0) {
            cantidadHojasPares++;
        }

        return new Resultados(sumaImpares, cantidadHojasPares);
    }
}
