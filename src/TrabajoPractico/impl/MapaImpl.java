package TrabajoPractico.impl;

import TrabajoPractico.api.ConjuntoTDA;
import TrabajoPractico.api.GrafoTDA;
import TrabajoPractico.api.MapaTDA;
import TrabajoPractico.api.PilaTDA;

import java.util.HashMap;
import java.util.Map;

public class MapaImpl implements MapaTDA {
    private GrafoTDA mapa;
    private ConjuntoTDA provincias;
    private Map<Integer, String> nombreProvincias;
    private Map<Integer, String> nombreCiudades;

    @Override
    public void InicializarMapa() {
        mapa = new GrafoMA();  // Asegúrate de que GrafoMA implementa GrafoTDA
        mapa.InicializarGrafo();
        provincias = new ConjuntoLD();  // Asegúrate de que ConjuntoLD implementa ConjuntoTDA
        provincias.InicializarConjunto();
        nombreProvincias = new HashMap<>();
        nombreCiudades = new HashMap<>();
    }

    @Override
    public void CargarProvincia(String provincia) {
        int provHash = provincia.hashCode();
        if (!provincias.Pertenece(provHash)) {
            provincias.Agregar(provHash);
            nombreProvincias.put(provHash, provincia);
        }
    }

    @Override
    public void CargarCiudad(String provincia, String ciudad) {
        int ciudadHash = ciudad.hashCode();
        if (!mapa.Vertices().Pertenece(ciudadHash)) {
            mapa.AgregarVertice(ciudadHash);
            nombreCiudades.put(ciudadHash, ciudad);
        }
    }

    @Override
    public void EliminarCiudad(String ciudad) {
        int ciudadHash = ciudad.hashCode();
        if (mapa.Vertices().Pertenece(ciudadHash)) {
            mapa.EliminarVertice(ciudadHash);
            nombreCiudades.remove(ciudadHash);
        }
    }

    @Override
    public void CargarRuta(String origen, String destino, int distancia) {
        int origenHash = origen.hashCode();
        int destinoHash = destino.hashCode();
        if (mapa.Vertices().Pertenece(origenHash) && mapa.Vertices().Pertenece(destinoHash)) {
            mapa.AgregarArista(origenHash, destinoHash, distancia);
        }
    }

    @Override
    public void ListarProvincias() {
        ConjuntoTDA provs = provincias;
        while (!provs.ConjuntoVacio()) {
            int prov = provs.Elegir();
            System.out.println(String.format("Provincia: %s", nombreProvincias.get(prov)));
            provs.Sacar(prov);
        }
    }

    @Override
    public void ListarCiudadesPorProvincia(String provincia) {
        // Necesita implementar un mapeo real para provincias y ciudades
    }

    @Override
    public void ListarCiudadesVecinas(String ciudad) {
        int ciudadHash = ciudad.hashCode();
        if (mapa.Vertices().Pertenece(ciudadHash)) {
            ConjuntoTDA adyacentes = mapa.VerticesAdyacentes(ciudadHash);
            while (!adyacentes.ConjuntoVacio()) {
                int vecino = adyacentes.Elegir();
                System.out.println(String.format("Ciudad vecina: %s", nombreCiudades.get(vecino)));
                adyacentes.Sacar(vecino);
            }
        }
    }

    @Override
    public void ListarCiudadesPuente(String ciudadA, String ciudadB) {
        int ciudadAHash = ciudadA.hashCode();
        int ciudadBHash = ciudadB.hashCode();
        if (mapa.Vertices().Pertenece(ciudadAHash) && mapa.Vertices().Pertenece(ciudadBHash)) {
            ConjuntoTDA adyacentesA = mapa.VerticesAdyacentes(ciudadAHash);
            while (!adyacentesA.ConjuntoVacio()) {
                int puente = adyacentesA.Elegir();
                if (mapa.VerticesAdyacentes(puente).Pertenece(ciudadBHash)) {
                    System.out.println(String.format("Ciudad puente: %s", nombreCiudades.get(puente)));
                    int distancia = mapa.PesoArista(ciudadAHash, puente) + mapa.PesoArista(puente, ciudadBHash);
                    System.out.println(String.format("Distancia total: %d km", distancia));
                }
                adyacentesA.Sacar(puente);
            }
        }
    }

    @Override
    public void ListarCiudadesPredecesoras(String ciudad) {
        int ciudadHash = ciudad.hashCode();
        if (mapa.Vertices().Pertenece(ciudadHash)) {
            ConjuntoTDA vertices = mapa.Vertices();
            while (!vertices.ConjuntoVacio()) {
                int vertice = vertices.Elegir();
                if (mapa.ExistenArista(vertice, ciudadHash)) {
                    System.out.println(String.format("Ciudad predecesora: %s", nombreCiudades.get(vertice)));
                }
                vertices.Sacar(vertice);
            }
        }
    }

    @Override
    public void ListarCiudadesExtremo() {
        ConjuntoTDA vertices = mapa.Vertices();
        while (!vertices.ConjuntoVacio()) {
            int vertice = vertices.Elegir();
            ConjuntoTDA adyacentes = mapa.VerticesAdyacentes(vertice);
            if (adyacentes.ConjuntoVacio()) {
                System.out.println(String.format("Ciudad extremo: %s", nombreCiudades.get(vertice)));
            }
            vertices.Sacar(vertice);
        }
    }

    @Override
    public void ListarCiudadesFuertementeConectadas() {
        ConjuntoTDA vertices = mapa.Vertices();
        while (!vertices.ConjuntoVacio()) {
            int vertice = vertices.Elegir();
            ConjuntoTDA adyacentes = mapa.VerticesAdyacentes(vertice);
            while (!adyacentes.ConjuntoVacio()) {
                int adyacente = adyacentes.Elegir();
                if (mapa.ExistenArista(adyacente, vertice)) {
                    System.out.println(String.format("Ciudades fuertemente conectadas: %s y %s", nombreCiudades.get(vertice), nombreCiudades.get(adyacente)));
                }
                adyacentes.Sacar(adyacente);
            }
            vertices.Sacar(vertice);
        }
    }

    @Override
    public void CalcularCamino(String ciudadA, String ciudadB) {
        int ciudadAHash = ciudadA.hashCode();
        int ciudadBHash = ciudadB.hashCode();
        if (mapa.Vertices().Pertenece(ciudadAHash) && mapa.Vertices().Pertenece(ciudadBHash)) {
            ConjuntoTDA visitados = new ConjuntoLD();  // Asegúrate de que ConjuntoLD implementa ConjuntoTDA
            visitados.InicializarConjunto();
            PilaTDA camino = new PilaLD();  // Asegúrate de que PilaLD implementa PilaTDA
            camino.InicializarPila();
            int distanciaTotal = CalcularCaminoAux(ciudadAHash, ciudadBHash, visitados, camino, 0);
            if (distanciaTotal != -1) {
                System.out.println(String.format("Distancia total: %d km", distanciaTotal));
                while (!camino.PilaVacia()) {
                    System.out.println(String.format("Ciudad: %s", nombreCiudades.get(camino.Tope())));
                    camino.Desapilar();
                }
            } else {
                System.out.println("No existe un camino entre las ciudades dadas.");
            }
        }
    }

    private int CalcularCaminoAux(int ciudadA, int ciudadB, ConjuntoTDA visitados, PilaTDA camino, int distancia) {
        if (ciudadA == ciudadB) {
            camino.Apilar(ciudadA);
            return distancia;
        }
        visitados.Agregar(ciudadA);
        ConjuntoTDA adyacentes = mapa.VerticesAdyacentes(ciudadA);
        while (!adyacentes.ConjuntoVacio()) {
            int adyacente = adyacentes.Elegir();
            if (!visitados.Pertenece(adyacente)) {
                int resultado = CalcularCaminoAux(adyacente, ciudadB, visitados, camino, distancia + mapa.PesoArista(ciudadA, adyacente));
                if (resultado != -1) {
                    camino.Apilar(ciudadA);
                    return resultado;
                }
            }
            adyacentes.Sacar(adyacente);
        }
        return -1;
    }

    @Override
    public void CargarDatosDePrueba() {
        CargarProvincia("Buenos Aires");
        CargarCiudad("Buenos Aires", "La Plata");
        CargarCiudad("Buenos Aires", "Mar del Plata");
        CargarCiudad("Buenos Aires", "CABA");
        CargarCiudad("Buenos Aires", "Tandil");
        
        CargarProvincia("Córdoba");
        CargarCiudad("Córdoba", "Ciudad de Córdoba");
        CargarCiudad("Córdoba", "Río Cuarto");
        CargarCiudad("Córdoba", "Villa Carlos Paz");

        CargarProvincia("Chubut");
        CargarCiudad("Chubut", "Puerto Madryn");
        CargarCiudad("Chubut", "Trelew");
        CargarCiudad("Chubut", "Rawson");

        CargarProvincia("Salta");
        CargarCiudad("Salta", "Cafayate");

        CargarRuta("La Plata", "Mar del Plata", 400);
        CargarRuta("Mar del Plata", "CABA", 400);
        CargarRuta("CABA", "Tandil", 300);
        CargarRuta("La Plata", "Tandil", 300);
        CargarRuta("Ciudad de Córdoba", "Río Cuarto", 200);
        CargarRuta("Río Cuarto", "Puerto Madryn", 1150);
        CargarRuta("Villa Carlos Paz", "Ciudad de Córdoba", 40);
        CargarRuta("Villa Carlos Paz", "Río Cuarto", 250);
        CargarRuta("Villa Carlos Paz", "Trelew", 1400);
        CargarRuta("Rawson", "Villa Carlos Paz", 1200);
        CargarRuta("Rawson", "Cafayate", 2200);
        CargarRuta("Rawson", "Trelew", 20);
    }
}
