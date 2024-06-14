package TrabajoPractico.impl;

import TrabajoPractico.api.ConjuntoTDA;

public class Provincia {
    private String nombre;
    private ConjuntoTDA ciudades;

    public Provincia(String nombre) {
        this.nombre = nombre;
        ciudades = new ConjuntoLD();  // Asegúrate de que ConjuntoLD implementa ConjuntoTDA
        ciudades.InicializarConjunto();
    }

    public String getNombre() {
        return nombre;
    }

    public ConjuntoTDA getCiudades() {
        return ciudades;
    }

    public void agregarCiudad(String ciudad) {
        ciudades.Agregar(ciudad.hashCode());
    }
}
