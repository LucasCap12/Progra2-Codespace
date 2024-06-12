package impl;

import api.*;

public class GestorDeReservas implements ReservaVuelos {

    private DicMultipleL diccionarioReservasPorVuelo;
    private DicMultipleL diccionarioReservasPorFecha;

    public GestorDeReservas() {
        diccionarioReservasPorVuelo = new DicMultipleL();
        diccionarioReservasPorFecha = new DicMultipleL();
    }

    @Override
    public void inicializarReserva() {
        diccionarioReservasPorVuelo.InicializarDiccionario();
        diccionarioReservasPorFecha.InicializarDiccionario();
    }

    @Override
    public void agregarReserva(int id_pasajero, int nro_vuelo, int nro_asiento, String fecha) {
        diccionarioReservasPorVuelo.Agregar(nro_vuelo, id_pasajero);
        diccionarioReservasPorFecha.Agregar(fecha, id_pasajero);
    }

    @Override
    public void eliminarReserva(int id_pasajero) {
        ConjuntoTDA vuelosDelPasajero = diccionarioReservasPorVuelo.Recuperar(id_pasajero);
        while (!vuelosDelPasajero.ConjuntoVacio()) {
            int nro_vuelo = vuelosDelPasajero.Elegir();
            diccionarioReservasPorVuelo.EliminarValor(nro_vuelo, id_pasajero);
            vuelosDelPasajero.Sacar(nro_vuelo);
        }
        while (!diccionarioReservasPorFecha.Claves().ConjuntoVacio()) {
            String fecha = diccionarioReservasPorFecha.Claves().Elegir();
            ConjuntoTDA reservasEnFecha = diccionarioReservasPorFecha.Recuperar(fecha);
            if (reservasEnFecha.Pertenece(id_pasajero)) {
                reservasEnFecha.Sacar(id_pasajero);
                if (reservasEnFecha.ConjuntoVacio()) {
                    diccionarioReservasPorFecha.Borrar(fecha);
                }
                break;
            }
        }
    }

    @Override
    public void actualizarAsiento(int id_pasajero, int nro_asiento) {
    }

    @Override
    public void actualizarVuelo(int id_pasajero, int nro_vuelo) {
    }

    @Override
    public void actualizarFecha(int id_pasajero, String fecha) {
    }

    @Override
    public void obtenerReserva(int id_pasajero) {
    }

    @Override
    public PilaTDA listaDeReserva() {
    }

    @Override
    public ColaTDA reservaPorVuelo(ColaTDA vuelo) {
    }

    @Override
    public ConjuntoTDA reservasPorFechas(String fecha) {
    }

    @Override
    public DiccionarioMultipleTDA listaPorVuelo() {
    }

    @Override
    public DiccionarioMultipleTDA listaPorFecha() {
    }
}
