import impl.SecuenciaEstatica;
import impl.SecuenciaDinamica;

/* NO CONFUNDIR
 * InsertarEnPos para insertar un valor entre dos valores existentes,
 * AgregarEnPos para sobrescribir un valor existente en una posición especificada
 */
public class EjercicioSecuenciaTDA {
    public static void main(String[] args) throws Exception {
        // Ejemplo Secuencia Estatica
        System.out.println("Ejemplo de uso de SecuenciaEstatica:");
        SecuenciaEstatica secuenciaEstatica = new SecuenciaEstatica();
        secuenciaEstatica.InicializarSecuencia();
        secuenciaEstatica.AgregarAlFinal(5);
        secuenciaEstatica.AgregarAlFinal(3);
        secuenciaEstatica.AgregarAlFinal(8);
        secuenciaEstatica.AgregarAlFinal(7);
        secuenciaEstatica.AgregarAlFinal(6);
        secuenciaEstatica.AgregarAlFinal(5);
        secuenciaEstatica.Mostrar();

        System.out.println("SecuenciaEstatica al agregar 10 en posición 1:");
        secuenciaEstatica.AgregarEnPos(10, 1); // Sobrescribir el valor en la posición 1 con 10 reemplazando el 3
        secuenciaEstatica.Mostrar();

        System.out.println("SecuenciaEstatica al insertar 20 en posición 2:");
        secuenciaEstatica.InsertarEnPos(20, 2); // Insertar 20 entre 10 y 3 sin sobreescribir ningun valor
        secuenciaEstatica.Mostrar();

        System.out.println("SecuenciaEstatica al eliminar la posición 3:");
        secuenciaEstatica.EliminarPos(3);
        secuenciaEstatica.Mostrar();

        System.out.println("SecuenciaEstatica al eliminar el valor 5:");
        secuenciaEstatica.EliminarTodosValor(5);
        secuenciaEstatica.Mostrar();

        System.out.println("SecuenciaEstatica al ser ordenada:");
        secuenciaEstatica.Ordenar();
        secuenciaEstatica.Mostrar();

        System.out.println("¿La secuencia está vacía? " + secuenciaEstatica.SecuenciaVacia());


        // Ejemplo Secuencia Dinamica
        System.out.println("\nEjemplo de uso de SecuenciaDinamica:");
        SecuenciaDinamica secuenciaDinamica = new SecuenciaDinamica();
        secuenciaDinamica.InicializarSecuencia();
        secuenciaDinamica.AgregarAlFinal(7);
        secuenciaDinamica.AgregarAlFinal(1);
        secuenciaDinamica.AgregarAlFinal(4);
        secuenciaDinamica.AgregarAlFinal(8);
        secuenciaDinamica.AgregarAlFinal(6);
        secuenciaDinamica.AgregarAlFinal(7);
        secuenciaDinamica.Mostrar();

        System.out.println("SecuenciaDinamica al agregar 10 en posición 1:");
        secuenciaDinamica.AgregarEnPos(10, 1); // sobreescribe la posicion 1 con valor 10
        secuenciaDinamica.Mostrar();

        System.out.println("SecuenciaDinamica al insertar 20 en posición 3:");
        secuenciaDinamica.InsertarEnPos(20, 3); // inserta el valor 20 en la posición 3 desplazando al resto
        secuenciaDinamica.Mostrar();

        System.out.println("SecuenciaDinamica al eliminar la posición 2:");
        secuenciaDinamica.EliminarPos(2);
        secuenciaDinamica.Mostrar();

        System.out.println("SecuenciaDinamica al eliminar el valor 7:");
        secuenciaDinamica.EliminarTodosValor(7);
        secuenciaDinamica.Mostrar();

        System.out.println("SecuenciaDinamica al ser ordenada:");
        secuenciaDinamica.Ordenar();
        secuenciaDinamica.Mostrar();

        System.out.println("¿La secuencia está vacía? " + secuenciaDinamica.SecuenciaVacia());
    }
}
