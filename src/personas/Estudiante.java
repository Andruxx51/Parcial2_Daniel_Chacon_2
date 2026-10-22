package personas;

import cursos.Curso;
import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private int[] notas;
    private int contadorNotas;
    private ArrayList<Curso> inscritos;

    public Estudiante(String nombre, int maxNotas) {
        this.nombre = nombre;
        this.notas = new int[maxNotas];
        this.contadorNotas = 0;
        this.inscritos = new ArrayList<>();
    }

    public void registrarNota(int nota) {
        if (contadorNotas < notas.length) {
            notas[contadorNotas] = nota;
            contadorNotas++;
        }
    }

    public double promedio() {
        if (contadorNotas == 0) {
            return 0.0;
        }
        int suma = 0;
        for (int i = 0; i < contadorNotas; i++) {
            suma += notas[i];
        }
        return (double) suma / contadorNotas;
    }

    public void inscribirCurso(Curso curso) {
        if (curso != null && !inscritos.contains(curso)) {
            inscritos.add(curso);
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int[] getNotas() { return notas; }
    public int getContadorNotas() { return contadorNotas; }
    public ArrayList<Curso> getInscritos() { return inscritos; }
}