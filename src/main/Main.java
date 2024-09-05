package main;

import enfermera.Enfermera;
import hospital.Hospital;
import turno.Turno;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Hospital
        Hospital hospital = new Hospital();

        // Listar las enfermeras
        System.out.println("Enfermeras del hospital:");
        for (Enfermera e : hospital.listarEnfermeras()) {
            System.out.println(e.getNombre() + " - " + e.getEspecialidad() + " - " + e.getEstado());
        }

        // Listar los turnos
        System.out.println("\nTurnos del hospital:");
        for (Turno t : hospital.listarTurnos()) {
            System.out.println(t.getTipoTurno() + " - " + t.getHoraInicio() + " a " + t.getHoraFin() + 
                               " - Enfermera: " + t.getEnfermeraAsignada().getNombre());
        }
    }
}

