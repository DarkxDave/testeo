package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import enfermera.Enfermera;
import turno.Turno;

public class Hospital {
    private Map<Integer, Enfermera> mapaEnfermeras;
    private List<Turno> turnos;

    // constructor
    public Hospital() {
        mapaEnfermeras = new HashMap<>();
        turnos = new ArrayList<>();
        inicializarDatosFijos();
    }

    // metodo para insertar manualmente una enfermera
    public void insertarEnfermeraManual() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Inserción manual de Enfermera:");
        System.out.print("ID: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.print("Nombre: ");
        String nombre = reader.readLine();
        System.out.print("Estado (Disponible/Descanso): ");
        String estado = reader.readLine();
        System.out.print("Especialidad: ");
        String especialidad = reader.readLine();

        Enfermera nuevaEnfermera = new Enfermera(id, nombre, estado, especialidad);
        mapaEnfermeras.put(id, nuevaEnfermera);
        System.out.println("Enfermera agregada correctamente.");
    }

    // metodo para insertar manualmente un turno
    public void insertarTurnoManual() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Inserción manual de Turno:");
        System.out.print("ID del turno: ");
        int idTurno = Integer.parseInt(reader.readLine());
        System.out.print("Hora de inicio (HH:mm): ");
        String horaInicio = reader.readLine();
        System.out.print("Hora de fin (HH:mm): ");
        String horaFin = reader.readLine();
        System.out.print("Tipo de turno (Mañana/Tarde/Noche): ");
        String tipoTurno = reader.readLine();

        System.out.print("ID de la enfermera asignada: ");
        int idEnfermera = Integer.parseInt(reader.readLine());

        Enfermera enfermeraAsignada = mapaEnfermeras.get(idEnfermera);
        if (enfermeraAsignada == null) {
            System.out.println("Enfermera no encontrada. Inserte primero la enfermera.");
        } else {
            Turno nuevoTurno = new Turno(idTurno, horaInicio, horaFin, tipoTurno, enfermeraAsignada);
            turnos.add(nuevoTurno);
            System.out.println("Turno agregado correctamente.");
        }
    }

    // metodo para inicializar los datos fijos
    private void inicializarDatosFijos() {
        // agregar 3 enfermeras
        Enfermera enfermera1 = new Enfermera(1, "Laura Martínez", "Disponible", "Urgencias");
        Enfermera enfermera2 = new Enfermera(2, "Ana Pérez", "Disponible", "Pediatría");
        Enfermera enfermera3 = new Enfermera(3, "María García", "Descanso", "Traumatología");

        mapaEnfermeras.put(enfermera1.getId(), enfermera1);
        mapaEnfermeras.put(enfermera2.getId(), enfermera2);
        mapaEnfermeras.put(enfermera3.getId(), enfermera3);

        // agregar 3 turnos
        Turno turno1 = new Turno(1, "08:00", "16:00", "Mañana", enfermera1);
        Turno turno2 = new Turno(2, "16:00", "00:00", "Tarde", enfermera2);
        Turno turno3 = new Turno(3, "00:00", "08:00", "Noche", enfermera3);

        turnos.add(turno1);
        turnos.add(turno2);
        turnos.add(turno3);

        // asignar turnos a las enfermeras
        enfermera1.asignarTurno(turno1);
        enfermera2.asignarTurno(turno2);
        enfermera3.asignarTurno(turno3);
    }

    // gestionar enfermeras
    public void agregarEnfermera(Enfermera enfermera) {
        mapaEnfermeras.put(enfermera.getId(), enfermera);
    }

    public List<Enfermera> listarEnfermeras() {
        return new ArrayList<>(mapaEnfermeras.values());
    }

    // gestionar turnos
    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public List<Turno> listarTurnos() {
        return turnos;
    }

    // asignar enfermera a un turno
    public boolean asignarEnfermeraATurno(int idTurno, int idEnfermera) {
        Turno turno = buscarTurnoPorId(idTurno);
        Enfermera enfermera = mapaEnfermeras.get(idEnfermera);
        if (turno != null && enfermera != null) {
            turno.setEnfermeraAsignada(enfermera);
            return true;
        }
        return false;
    }

    // buscar turno por ID
    private Turno buscarTurnoPorId(int idTurno) {
        for (Turno turno : turnos) {
            if (turno.getId() == idTurno) {
                return turno;
            }
        }
        return null;
    }
}
