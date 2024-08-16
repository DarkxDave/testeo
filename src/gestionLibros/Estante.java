package gestionLibros;

import modelo.Libro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estante 
{
    private Map<String, Libro> libros;

    public Estante() 
    {
        this.libros = new HashMap<>();
    }

    public void agregarLibro(Libro libro) 
    {
        if (libros.containsKey(libro.getCodigo())) 
        {
            System.out.println("El libro con el código " + libro.getCodigo() + " ya existe.");
        } 
        else 
        {
            libros.put(libro.getCodigo(), libro);
            System.out.println("Libro agregado exitosamente.");
        }
    }

    public Libro buscarLibro(String codigo) 
    {
        return libros.get(codigo);
    }

    public void eliminarLibro(String codigo) 
    {
        if (libros.remove(codigo) != null) 
        {
            System.out.println("Libro eliminado exitosamente.");
        } 
        else 
        {
            System.out.println("Libro no encontrado.");
        }
    }

    public void prestarLibro(String codigo) 
    {
        Libro libro = libros.get(codigo);
        if (libro != null) 
        {
            libro.prestar();
            System.out.println("Registro de préstamo actualizado.");
        } 
        else 
        {
            System.out.println("Libro no encontrado.");
        }
    }

    public List<Libro> obtenerTodosLosLibros() 
    {
        return new ArrayList<>(libros.values());
    }
}
