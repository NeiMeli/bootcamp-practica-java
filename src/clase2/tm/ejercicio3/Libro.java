package clase2.tm.ejercicio3;

public class Libro {

    private String titulo;
    private long isbn;
    private String autor;
    private boolean disponible; // no quiero exponer setters ni getters de este atributo

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Libro(String titulo, long isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        disponible = true;
    }

    public Libro() {
        this("sin titulo", 0, "sin autor");
    }

    public void prestamo() {
        if (!estaDisponible()) {
            throw new LibroException("El libro no está disponible");
        }
        disponible = false;
    }
    public void devolucion() {
        if (estaDisponible()) {
            throw new LibroException("El libro no está prestado");
        }
        disponible = true;
    }

    /*
     * Si dejo el @Override y le cambio el nombre al método aparece un error de compilación.
     * Esto es así porque no estaría sobreescribiendo ningún método de la clase padre (Object)
     */
    @Override
    public String toString() {
        return String.format("Titulo: %s - isbn: %s - Autor: %s - Estado: %s", titulo, isbn, autor, getDisponibleAsString());
    }

    private String getDisponibleAsString() {
        return estaDisponible() ? "Disponible" : "Prestado";
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public static class LibroException extends RuntimeException {
        public LibroException(String message) {
            super(message);
        }
    }
}
