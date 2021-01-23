package clase2.tm.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void parametrizedConstructor() {
        Libro libro = new Libro("Libro", 123, "Autor");
        assertEquals("Libro", libro.getTitulo());
        assertEquals(123, libro.getIsbn());
        assertEquals("Autor", libro.getAutor());
        assertTrue(libro.estaDisponible());
    }

    @Test
    void prestamo() {
        Libro libro = new Libro("Libro", 123, "Autor");
        libro.prestamo();
        assertFalse(libro.estaDisponible());
        assertThrows(Libro.LibroException.class, libro::prestamo);
    }

    @Test
    void devolucion() {
        Libro libro = new Libro("Libro", 123, "Autor");
        assertThrows(Libro.LibroException.class, libro::devolucion);
        libro.prestamo();
        assertFalse(libro.estaDisponible());
        libro.devolucion();
        assertTrue(libro.estaDisponible());
    }
}