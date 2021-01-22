package exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FraccionTest {

    @Test
    void sumar() {
        // int + float
        assertEquals(2.5f, Fraccion.sumar(2, 0.5f));
        // int + int
        assertEquals(5f, Fraccion.sumar(2, 3));
        // float + int
        assertEquals(2.5f, Fraccion.sumar(0.5f, 2));
        // float + float
        assertEquals(5f, Fraccion.sumar(2.5f, 2.5f));
    }

    @Test
    void restar() {
        // int - float
        assertEquals(1.5f, Fraccion.restar(2, 0.5f));
        // int - int
        assertEquals(5f, Fraccion.restar(7, 2));
        // float - int
        assertEquals(1.5f, Fraccion.restar(3.5f, 2));
        // float - float
        assertEquals(1.8f, Fraccion.restar(2.3f, 0.5f));
    }

    @Test
    void dividir() {
        // int / float
        assertEquals(2, Fraccion.dividir(5, 2.5f));
        // int / int
        assertEquals(2.5f, Fraccion.dividir(5, 2));
        // float / int
        assertEquals(3.3f, Fraccion.dividir(6.6f, 2));
        // float / float
        assertEquals(2, Fraccion.dividir(6.6f, 3.3f));
    }

    @Test
    void multiplicar() {
        // int * float
        assertEquals(10, Fraccion.multiplicar(4, 2.5f));
        // int * int
        assertEquals(9, Fraccion.multiplicar(3, 3));
        // float * int
        assertEquals(12.4f, Fraccion.multiplicar(6.2f, 2));
        // float * float
        assertEquals(49.9f, Fraccion.multiplicar(6.4f, 7.8f));
    }
}