package modelo;

public class Libro 
{
    private String codigo;
    private String titulo;
    private String autor;
    private int contadorPrestamos;

    public Libro(String codigo, String titulo, String autor) 
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.contadorPrestamos = 0;
    }

    public String getCodigo() 
    {
        return codigo;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public String getAutor() 
    {
        return autor;
    }

    public int getContadorPrestamos() 
    {
        return contadorPrestamos;
    }

    public void prestar() 
    {
        this.contadorPrestamos++;
    }

    @Override
    public String toString() 
    {
        return "Código: " + codigo + ", Título: " + titulo + ", Autor: " + autor + ", Prestamos: " + contadorPrestamos;
    }
}
