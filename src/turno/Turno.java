package turno;
import java.time.*;


public class Turno {
    private int id;
    private String tipoTurno; // Mañana, tarde, noche, 8 horas cada uno
    private Enfermera enfermeraAsignada;
    
    
    //constructor
    public Turno(int id, LocalDate fechaInicio, LocalDate fechaFin, String tipoTurno, Enfermera enfermeraAsignada) {
        this.id = id;
        this.tipoTurno = tipoTurno;
        this.enfermeraAsignada = enfermeraAsignada;
    }
    
    //getters
    public int getId() {
        return id;
    }
    
    public String getTipoTurno() {
    	return tipoTurno;
    }
    
    public Enfermera getEnfermeraAsignada() {
    	return enfermeraAsignada;
    }
    
    //setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }
    
    public void setEnfermeraAsignada(Enfermera enfermeraAsignada) {
        this.enfermeraAsignada = enfermeraAsignada;
    }
}
