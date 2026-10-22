package servicios;

import cursos.*;
import java.util.ArrayList;
import java.util.List;

public class Recomendador {

    public List<Curso> recomendar(HistorialAcademico historial) {
        List<Curso> sugerencias = new ArrayList<>();
        if (historial == null) {
            return sugerencias;
        }

        double prom = historial.promedio();

        if (prom >= 4.0) {
            sugerencias.add(new CursoElectivo("REC_ELE", "Curso Electivo Avanzado", 3));
        } else {
            sugerencias.add(new CursoNivelatorio("REC_NIV", "Curso Nivelatorio de Refuerzo", 2));
        }

        return sugerencias;
    }
}