import api.SistemaAlumnos;
import impl.SistemaAlumnosImpl;

public class EjercicioSistemaAlumno {
    public static void main(String[] args) {
        // Creamos una instancia del sistema de alumnos
        SistemaAlumnos sistemaAlumnos = new SistemaAlumnosImpl();

        // Agregamos notas para algunos alumnos
        sistemaAlumnos.agregarNota(1001, 7);
        sistemaAlumnos.agregarNota(1001, 8);
        sistemaAlumnos.agregarNota(1002, 6);
        sistemaAlumnos.agregarNota(1002, 7);
        sistemaAlumnos.agregarNota(1003, 5);
        sistemaAlumnos.agregarNota(1004, 3);
        sistemaAlumnos.agregarNota(1004, 2);

        // Mostramos las notas de un alumno
        System.out.println("Notas del alumno con legajo 1001:");
        sistemaAlumnos.mostrarNotas(1001);

        // Calculamos el promedio de un alumno
        double promedioAlumno1002 = sistemaAlumnos.promedioAlumno(1002);
        System.out.println("Promedio del alumno con legajo 1002: " + promedioAlumno1002);

        // Calculamos el promedio general de todos los alumnos
        double promedioGeneral = sistemaAlumnos.promedioGeneral();
        System.out.println("Promedio general de todos los alumnos: " + promedioGeneral);

        // Mostramos los alumnos aprobados
        System.out.println("Alumnos aprobados:");
        sistemaAlumnos.mostrarAlumnosAprobados();

        // Borramos un alumno
        sistemaAlumnos.borrarAlumno(1003);
        System.out.println("Alumno con legajo 1003 borrado.");

        // Volvemos a mostrar los alumnos aprobados después de borrar uno
        System.out.println("Alumnos aprobados después de borrar un alumno:");
        sistemaAlumnos.mostrarAlumnosAprobados();
    }
}
/*
 * Diccionario Múltiple (DiccionarioMultipleTDA): Esta estructura se utiliza para almacenar las notas de los alumnos.
 *  En este diccionario, las claves son los legajos de los alumnos, y los valores son conjuntos (representados por la
 *  interfaz ConjuntoTDA) que contienen las notas asociadas a cada alumno.

Conjunto (ConjuntoTDA): Esta estructura se utiliza para representar conjuntos de elementos. En el contexto
 del sistema de alumnos, se utiliza para almacenar las notas asociadas a cada alumno. Por ejemplo, un conjunto
  puede contener todas las notas asociadas a un determinado legajo de alumno.

SistemaAlumnos: Esta interfaz proporciona métodos para interactuar con el sistema de gestión de alumnos. Los
 métodos permiten agregar notas, borrar alumnos, mostrar notas, calcular promedios individuales y generales, y
  mostrar alumnos aprobados. Esta interfaz actúa como una interfaz de usuario para interactuar con las estructuras de datos subyacentes.

Cómo interactúan estas estructuras de datos en el código:

Agregar Nota: Cuando se agrega una nota para un alumno, se utiliza el diccionario múltiple. Se agrega la nota
 al conjunto correspondiente al legajo del alumno. Si el alumno no existe en el diccionario, se crea una nueva entrada para él.

Borrar Alumno: Al borrar un alumno, se elimina la entrada correspondiente en el diccionario múltiple. Esto también
 elimina todas las notas asociadas a ese alumno.

Mostrar Notas: Para mostrar las notas de un alumno, se recupera el conjunto de notas asociado a su legajo del
 diccionario múltiple y se muestran todas las notas en ese conjunto.

Promedio Alumno: Para calcular el promedio de un alumno, se recupera el conjunto de notas asociado a su legajo
 del diccionario múltiple y se calcula el promedio de esas notas.

Promedio General: Para calcular el promedio general de todos los alumnos, se recorren todas las entradas del
 diccionario múltiple. Por cada entrada, se recupera el conjunto de notas asociado y se suman todas las notas
  para luego calcular el promedio general.

Mostrar Alumnos Aprobados: Para mostrar los alumnos aprobados, se recorren todas las entradas del diccionario múltiple.
 Por cada entrada, se calcula el promedio del alumno y se muestra si es mayor o igual a 4.
 */

/*                     SistemaAlumnos
                           |
                           v
             -------------------------------------
             |              Diccionario           |
             |        (DiccionarioMultipleTDA)    |
             -------------------------------------
                           |
                           v
        ---------------------------------------
        |             Conjunto                 |
        |        (ConjuntoTDA)                  |
        ---------------------------------------
 */