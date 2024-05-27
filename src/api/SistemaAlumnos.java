package api;

public interface SistemaAlumnos {
    void agregarNota(int legajo, int nota);
    void borrarAlumno(int legajo);
    void mostrarNotas(int legajo);
    double promedioAlumno(int legajo);
    double promedioGeneral();
    void mostrarAlumnosAprobados();
}

//practica simulacro parcial