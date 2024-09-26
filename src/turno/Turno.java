package turno;

import enfermera.Enfermera;

public class Turno {
    private int id;
    private String tipoTurno; // Mañana, tarde, noche, 8 horas cada uno
    private String horaInicio; // Horario en formato 24 horas (HH:mm)
    private String horaFin; // Horario en formato 24 horas (HH:mm)
    private Enfermera enfermeraAsignada;

    // Constructor
    public Turno(int id, String horaInicio, String horaFin, String tipoTurno, Enfermera enfermeraAsignada) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoTurno = tipoTurno;
        this.enfermeraAsignada = enfermeraAsignada;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTipoTurno() {
    	return tipoTurno;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public Enfermera getEnfermeraAsignada() {
    	return enfermeraAsignada;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setEnfermeraAsignada(Enfermera enfermeraAsignada) {
        this.enfermeraAsignada = enfermeraAsignada;
        enfermeraAsignada.asignarTurno(this); // También asignar este turno a la enfermera
    }

    // Método para validar el formato de las horas (HH:mm)
    public static boolean validarHora(String hora) {
        return hora.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
}
