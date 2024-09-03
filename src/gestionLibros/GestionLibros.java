package gestionLibros;

import modelo.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//asdnbiorbgf
public class GestionLibros 
{
    private List<Estante> estantes;

    public GestionLibros() 
    {
        this.estantes = new ArrayList<>();
    }

    public void agregarEstante(Estante estante) 
    {
        estantes.add(estante);
    }

    public Estante obtenerEstante(int indice) 
    {
        if (indice >= 0 && indice < estantes.size()) 
        {
            return estantes.get(indice);
        }
        return null;
    }

    private static void manejarOpcion(int opcion, Estante estante, Scanner scanner) 
    {
        String codigo;
        switch (opcion) 
        {
            case 1:
                System.out.print("Ingrese el código del libro: ");
                codigo = scanner.nextLine();
                System.out.print("Ingrese el título del libro: ");
                String titulo = scanner.nextLine();
                System.out.print("Ingrese el autor del libro: ");
                String autor = scanner.nextLine();
                Libro nuevoLibro = new Libro(codigo, titulo, autor);
                estante.agregarLibro(nuevoLibro);
                break;

            case 2:
                System.out.print("Ingrese el código del libro que desea buscar: ");
                codigo = scanner.nextLine();
                Libro libroBuscado = estante.buscarLibro(codigo);
                if (libroBuscado != null) 
                {
                    System.out.println("Datos del libro:");
                    System.out.println(libroBuscado);
                } 
                else 
                {
                    System.out.println("Libro no encontrado.");
                }
                break;

            case 3:
                System.out.print("Ingrese el código del libro que desea eliminar: ");
                codigo = scanner.nextLine();
                estante.eliminarLibro(codigo);
                break;

            case 4:
                System.out.print("Ingrese el código del libro que desea registrar como prestado: ");
                codigo = scanner.nextLine();
                estante.prestarLibro(codigo);
                break;

            case 5:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            GestionLibros gestionLibros = new GestionLibros();
            Estante estantePrincipal = new Estante();
            gestionLibros.agregarEstante(estantePrincipal);

            int opcion;
            do {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Agregar libro");
                System.out.println("2. Buscar libro");
                System.out.println("3. Eliminar libro");
                System.out.println("4. Registrar libro como 'prestado'");
                System.out.println("5. Salir");
                System.out.print("Opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                manejarOpcion(opcion, estantePrincipal, scanner);

            } while (opcion != 5);
        }
    }
}
