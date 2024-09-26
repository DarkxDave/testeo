package hospital;

import java.util.ArrayList;
import java.util.List;

public class Enfermera {
    private int id;
    private String nombre, estado, especialidad;
    private List<Turno> turnosAsignados;

    // Constructor
    public Enfermera(int id, String nombre, String estado, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.especialidad = especialidad;
        this.turnosAsignados = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Turno> getTurnosAsignados() {
        return turnosAsignados;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Asignar turnos a la enfermera
    public void asignarTurno(Turno turno) {
        turnosAsignados.add(turno);
    }
}
