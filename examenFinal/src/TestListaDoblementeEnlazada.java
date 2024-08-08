import impl.ListaDoblementeEnlazada;

public class TestListaDoblementeEnlazada {
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
        
        lista.Agregar(1);
        lista.Agregar(2);
        lista.Agregar(3);
        lista.Agregar(2);
        lista.Agregar(4);
        lista.Agregar(2);

        System.out.println("Lista de cabeza a cola:");
        lista.MostrarCabezaCola();

        System.out.println("Lista de cola a cabeza:");
        lista.MostrarColaCabeza();

        lista.Eliminar(2);

        System.out.println("Lista después de eliminar la primera ocurrencia de 2:");
        lista.MostrarCabezaCola();

        lista.EliminarTodos(2);

        System.out.println("Lista después de eliminar todas las ocurrencias de 2:");
        lista.MostrarCabezaCola();
    }
}
