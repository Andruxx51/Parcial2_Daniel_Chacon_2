package servicios;

import personas.Estudiante;

public class HistorialAcademico {

    private Estudiante estudiante;

    public HistorialAcademico(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public double promedio() {
        if (estudiante == null) {
            return 0.0;
        }
        return estudiante.promedio();
    }

    public int cantidadCursos() {
        if (estudiante == null || estudiante.getInscritos() == null) {
            return 0;
        }
        return estudiante.getInscritos().size();
    }

    public Estudiante getEstudiante() { return estudiante; }
}