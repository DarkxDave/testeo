package enfermera;


public class Enfermera {
    private int id;
    private String nombre, estado, especialidad;
    
    //constructor
    public Enfermera(int id, String nombre, String estado, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.especialidad = especialidad;
    }
    
    //getters
    public int getId(){
    	return id;
    }
    
    public String getNombre(){
    	return nombre;
    }
    
    public String getEstado(){
    	return estado;
    }
    
    public String getEspecialidad(){
    	return especialidad;
    }
    
    //setters
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
}
