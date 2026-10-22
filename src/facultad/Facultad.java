package facultad;

import plan.PlanEstudios;
import java.util.ArrayList;

public class Facultad {

    private String nombre;
    private ArrayList<PlanEstudios> planes;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(PlanEstudios plan) {
        if (plan != null && !planes.contains(plan)) {
            this.planes.add(plan);
        }
    }

    public int totalCursos() {
        int total = 0;
        for (PlanEstudios plan : planes) {
            total += plan.getCursos().size();
        }
        return total;
    }

    public String getNombre() { return nombre; }
    public ArrayList<PlanEstudios> getPlanes() { return planes; }
}