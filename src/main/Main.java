package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import hospital.Hospital;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Hospital hospital = new Hospital();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("\nMenú del Sistema Hospitalario:");
            System.out.println("1. Insertar enfermera manualmente");
            System.out.println("2. Insertar turno manualmente");
            System.out.println("3. Listar enfermeras");
            System.out.println("4. Listar turnos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1:
                    hospital.insertarEnfermeraManual();
                    break;
                case 2:
                    hospital.insertarTurnoManual();
                    break;
                case 3:
                    System.out.println("\nLista de Enfermeras:");
                    hospital.listarEnfermeras().forEach(e -> System.out.println(e.getNombre()));
                    break;
                case 4:
                    System.out.println("\nLista de Turnos:");
                    hospital.listarTurnos().forEach(t -> 
                        System.out.println("Turno " + t.getTipoTurno() + " (" + t.getHoraInicio() + " - " + t.getHoraFin() + 
                                           ") - Enfermera: " + t.getEnfermeraAsignada().getNombre()));
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
