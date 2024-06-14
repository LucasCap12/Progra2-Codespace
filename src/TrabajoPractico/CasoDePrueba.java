package TrabajoPractico;
import TrabajoPractico.api.MapaTDA;
import TrabajoPractico.impl.MapaImpl;

public class CasoDePrueba {
    public static void main(String[] args) {
        MapaTDA mapa = new MapaImpl();
        mapa.InicializarMapa();
        mapa.CargarDatosDePrueba();
        mapa.ListarProvincias();
        mapa.ListarCiudadesPorProvincia("Buenos Aires");
        mapa.ListarCiudadesVecinas("CABA");
        mapa.ListarCiudadesPuente("CABA", "Ciudad de Córdoba");
        mapa.ListarCiudadesPredecesoras("Mar del Plata");
        mapa.ListarCiudadesExtremo();
        mapa.ListarCiudadesFuertementeConectadas();
        mapa.CalcularCamino("CABA", "Ciudad de Córdoba");
    }
}
