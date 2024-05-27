package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.SistemaAlumnos;

public class SistemaAlumnosImpl implements SistemaAlumnos {
    private DiccionarioMultipleTDA alumnos;

    public SistemaAlumnosImpl() {
        this.alumnos = new DicMultipleL(); // Utiliza la implementación proporcionada de DiccionarioMultipleTDA
        this.alumnos.InicializarDiccionario();
    }

    @Override
    public void agregarNota(int legajo, int nota) {
        alumnos.Agregar(legajo, nota);
    }

    @Override
    public void borrarAlumno(int legajo) {
        alumnos.Eliminar(legajo);
    }

    @Override
    public void mostrarNotas(int legajo) {
        ConjuntoTDA notas = alumnos.Recuperar(legajo);
        while (!notas.ConjuntoVacio()) {
            int nota = notas.Elegir();
            System.out.println("Nota: " + nota);
            notas.Sacar(nota);
        }
    }

    @Override
    public double promedioAlumno(int legajo) {
        ConjuntoTDA notas = alumnos.Recuperar(legajo);
        int suma = 0;
        int cantidadNotas = 0;
        while (!notas.ConjuntoVacio()) {
            int nota = notas.Elegir();
            suma += nota;
            cantidadNotas++;
            notas.Sacar(nota);
        }
        return cantidadNotas > 0 ? (double) suma / cantidadNotas : 0;
    }

    @Override
    public double promedioGeneral() {
        ConjuntoTDA claves = alumnos.Claves();
        int sumaTotal = 0;
        int cantidadTotalNotas = 0;
        while (!claves.ConjuntoVacio()) {
            int legajo = claves.Elegir();
            ConjuntoTDA notas = alumnos.Recuperar(legajo);
            while (!notas.ConjuntoVacio()) {
                int nota = notas.Elegir();
                sumaTotal += nota;
                cantidadTotalNotas++;
                notas.Sacar(nota);
            }
            claves.Sacar(legajo);
        }
        return cantidadTotalNotas > 0 ? (double) sumaTotal / cantidadTotalNotas : 0;
    }

    @Override
    public void mostrarAlumnosAprobados() {
        ConjuntoTDA claves = alumnos.Claves();
        while (!claves.ConjuntoVacio()) {
            int legajo = claves.Elegir();
            double promedio = promedioAlumno(legajo);
            if (promedio >= 4) {
                System.out.println("Legajo: " + legajo + ", Promedio: " + promedio);
            }
            claves.Sacar(legajo);
        }
    }
}
