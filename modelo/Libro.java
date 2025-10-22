package modelo;

public class Libro {
    public String titulo;
    public String autor;
    public String codigo;

    public Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Código: " + codigo;
    }
}

