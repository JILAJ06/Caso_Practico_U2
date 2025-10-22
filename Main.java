import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Libro;

public class Main {
    private static List<Libro> catalogo = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nCatálogo de Libros");
            System.out.println("1. Insertar libro");
            System.out.println("2. Buscar y modificar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Ver catálogo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    insertarLibro(sc);
                    break;
                case 2:
                    buscarYModificar(sc);
                    break;
                case 3:
                    eliminarLibro(sc);
                    break;
                case 4:
                    mostrarCatalogo();
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }

    // Inserción ordenada por título
    private static void insertarLibro(Scanner sc) {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        Libro nuevo = new Libro(titulo, autor, codigo);
        int i = 0;
        while (i < catalogo.size() && catalogo.get(i).titulo.compareToIgnoreCase(titulo) < 0) {
            i++;
        }
        catalogo.add(i, nuevo);
        System.out.println("Libro insertado correctamente.");
    }

    // Búsqueda y modificación por título
    private static void buscarYModificar(Scanner sc) {
        System.out.print("Título a buscar: ");
        String titulo = sc.nextLine();
        for (Libro libro : catalogo) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado: " + libro);
                System.out.print("Nuevo autor (dejar vacío para no cambiar): ");
                String autor = sc.nextLine();
                if (!autor.isEmpty()) libro.autor = autor;
                System.out.print("Nuevo código (dejar vacío para no cambiar): ");
                String codigo = sc.nextLine();
                if (!codigo.isEmpty()) libro.codigo = codigo;
                System.out.println("Libro modificado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    // Eliminación por título
    private static void eliminarLibro(Scanner sc) {
        System.out.print("Título a eliminar: ");
        String titulo = sc.nextLine();
        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).titulo.equalsIgnoreCase(titulo)) {
                catalogo.remove(i);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    // Mostrar catálogo
    private static void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (Libro libro : catalogo) {
                System.out.println(libro);
            }
        }
    }
}