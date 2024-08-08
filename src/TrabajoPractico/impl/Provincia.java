package TrabajoPractico.impl;

import TrabajoPractico.api.ConjuntoTDA;
import TrabajoPractico.impl.ConjuntoLD;

public class Provincia {
    public String nombre;
    public ConjuntoTDA ciudades;
    public String[] nombresCiudades;
    public int indiceCiudad;

    public void InicializarProvincia() {
        nombre = "";
        ciudades = new ConjuntoLD();
        ciudades.InicializarConjunto();
        nombresCiudades = new String[100]; // Ajusta el tamaño según sea necesario
        indiceCiudad = 0;
    }

    public void AgregarCiudad(int ciudadHash, String nombreCiudad) {
        ciudades.Agregar(ciudadHash);
        nombresCiudades[indiceCiudad++] = nombreCiudad;
    }

    public String getCiudadNombre(int ciudadHash) {
        for (int i = 0; i < indiceCiudad; i++) {
            if (nombresCiudades[i].hashCode() == ciudadHash) {
                return nombresCiudades[i];
            }
        }
        return null;
    }
}
