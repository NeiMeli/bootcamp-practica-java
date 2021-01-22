package exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContadorTest {

    @Test
    void incrementar() {
        Contador contador = new Contador();
        int valor = contador.getValor();
        contador.incrementar();
        assertEquals(valor + 1, contador.getValor());
        contador.incrementar();
        assertEquals(valor + 2, contador.getValor());
    }

    @Test
    void decrementar() {
        Contador contador = new Contador();
        int valor = contador.getValor();
        contador.decrementar();
        assertEquals(valor  -1, contador.getValor());
        contador.decrementar();
        assertEquals(valor - 2, contador.getValor());
    }

    @Test
    void defaultConstructor() {
        Contador contador = new Contador();
        assertEquals(0, contador.getValor());
    }

    @Test
    void parametrizedConstructor() {
        Contador contador = new Contador(5);
        assertEquals(5, contador.getValor());
    }
}