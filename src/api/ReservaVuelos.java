package api;

/*
 * Sistema de reservas de vuelos para una aerolinea. Necesitas implementar una estructura llamada GestorDeReservas.
 * Esta estructura se encargara de administrar las teservas de los pasajeros. Debe tenr las siguientes operaciones:
 */
public interface ReservaVuelos {

    void inicializarReserva(); //inicializa el gestor de reservas.
    void agregarReserva(int id_pasajero, int nro_vuelo, int nro_asiento, String fecha); //agrega una nueva reserva al sistema con un identificador unico de pasajeros, el numero de vuelo el numero de asitno y fecha del vuelo
    void eliminarReserva(int id_pasajero);//elimina una reserva del sistema por el identificador unico del pasajero
    void actualizarAsiento(int id_pasajero, int nro_asiento);//actualiza el numero de asiento de reserva especifica
    void actualizarVuelo(int id_pasajero,int nro_vuelo);//actualiza el vuelvo de una reserva especifica
    void actualizarFecha(int id_pasajero, String fecha);//actualiza la fecha de una reservacion especifica
    void obtenerReserva(int id_pasajero);//devuelve la informacion d euna reserva especifica incluyendo el numero de vuelo y le numero de asiento
    void listaDeReserva();//devuelve una pilaTDA de todas las reservas en el sistema
    void reservaPorVuelo(ColaTDA vuelvo);//devuelve una ColaTDA de reservas de un vuelo especifico
    void reservasPorFechas(String fecha);//devuelve un ConjuntoTDA de reservas de una fecha especifica
    void listaPorVuelo();//devuelve un DiccionarioMultipleTDA en el cual las keys son los numeros de vuelo y los values los ids de las reservas de dicho vuelo
    void listaPorFecha();//devuelve un DiccionarioMultipleTDA en el cual las keys son las fechas de las reservas y los values los ids de las reservas que tengan es fecha estipulada

}
