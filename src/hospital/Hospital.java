package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enfermera.Enfermera;
import turno.Turno;

public class Hospital {
    private List<Enfermera> enfermeras;
    private List<Turno> turnos;

    // Constructor
    public Hospital() {
        enfermeras = new ArrayList<>();
        turnos = new ArrayList<>();
        inicializarDatosFijos();
    }
    
 // Método para insertar manualmente una enfermera
    public void insertarEnfermeraManual() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserción manual de Enfermera:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Estado (Disponible/Descanso): ");
        String estado = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Enfermera nuevaEnfermera = new Enfermera(id, nombre, estado, especialidad);
        enfermeras.add(nuevaEnfermera);
        System.out.println("Enfermera agregada correctamente.");
    }

 // Método para insertar manualmente un turno
    public void insertarTurnoManual() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserción manual de Turno:");
        System.out.print("ID del turno: ");
        int idTurno = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea
        System.out.print("Hora de inicio (HH:mm): ");
        String horaInicio = sc.nextLine();
        System.out.print("Hora de fin (HH:mm): ");
        String horaFin = sc.nextLine();
        System.out.print("Tipo de turno (Mañana/Tarde/Noche): ");
        String tipoTurno = sc.nextLine();
        
        System.out.print("ID de la enfermera asignada: ");
        int idEnfermera = sc.nextInt();

        Enfermera enfermeraAsignada = buscarEnfermeraPorId(idEnfermera);
        if (enfermeraAsignada == null) {
            System.out.println("Enfermera no encontrada. Inserte primero la enfermera.");
        } else {
            Turno nuevoTurno = new Turno(idTurno, horaInicio, horaFin, tipoTurno, enfermeraAsignada);
            turnos.add(nuevoTurno);
            System.out.println("Turno agregado correctamente.");
        }
    }
    
    // Método para inicializar los datos fijos
    private void inicializarDatosFijos() {
        // Agregar 3 enfermeras
        Enfermera enfermera1 = new Enfermera(1, "Laura Martínez", "Disponible", "Urgencias");
        Enfermera enfermera2 = new Enfermera(2, "Ana Pérez", "Disponible", "Pediatría");
        Enfermera enfermera3 = new Enfermera(3, "María García", "Descanso", "Traumatología");

        enfermeras.add(enfermera1);
        enfermeras.add(enfermera2);
        enfermeras.add(enfermera3);

        // Agregar 3 turnos
        Turno turno1 = new Turno(1, "08:00", "16:00", "Mañana", enfermera1);
        Turno turno2 = new Turno(2, "16:00", "00:00", "Tarde", enfermera2);
        Turno turno3 = new Turno(3, "00:00", "08:00", "Noche", enfermera3);

        turnos.add(turno1);
        turnos.add(turno2);
        turnos.add(turno3);

        // Asignar turnos a las enfermeras
        enfermera1.asignarTurno(turno1);
        enfermera2.asignarTurno(turno2);
        enfermera3.asignarTurno(turno3);
    }

    // Gestionar Enfermeras
    public void agregarEnfermera(Enfermera enfermera) {
        enfermeras.add(enfermera);
    }

    public List<Enfermera> listarEnfermeras() {
        return enfermeras;
    }

    // Gestionar Turnos
    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public List<Turno> listarTurnos() {
        return turnos;
    }

    // Asignar enfermera a un turno
    public boolean asignarEnfermeraATurno(int idTurno, int idEnfermera) {
        Turno turno = buscarTurnoPorId(idTurno);
        Enfermera enfermera = buscarEnfermeraPorId(idEnfermera);
        if (turno != null && enfermera != null) {
            turno.setEnfermeraAsignada(enfermera);
            return true;
        }
        return false;
    }

    // Buscar enfermera por ID
    private Enfermera buscarEnfermeraPorId(int idEnfermera) {
        for (Enfermera enfermera : enfermeras) {
            if (enfermera.getId() == idEnfermera) {
                return enfermera;
            }
        }
        return null;
    }

    // Buscar turno por ID
    private Turno buscarTurnoPorId(int idTurno) {
        for (Turno turno : turnos) {
            if (turno.getId() == idTurno) {
                return turno;
            }
        }
        return null;
    }
}
