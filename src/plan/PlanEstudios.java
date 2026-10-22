package plan;

import cursos.*;
import java.util.ArrayList;

public class PlanEstudios {

    private String nombre;
    private ArrayList<Curso> cursos;

    public PlanEstudios(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
        // Composición: se crean los cursos dentro del constructor usando el método privado
        agregarCurso(new CursoObligatorio("OBL1", "Cálculo", 4));
        agregarCurso(new CursoElectivo("ELE1", "Bases de Datos", 3));
        agregarCurso(new CursoNivelatorio("NIV1", "Matemáticas Básicas", 2));
    }

    private void agregarCurso(Curso curso) {
        if (curso != null) {
            this.cursos.add(curso);
        }
    }

    public double dificultadPromedio() {
        if (cursos.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Curso c : cursos) {
            suma += c.dificultadEsperada();
        }
        return suma / cursos.size();
    }

    public String getNombre() { return nombre; }
    public ArrayList<Curso> getCursos() { return cursos; }
}