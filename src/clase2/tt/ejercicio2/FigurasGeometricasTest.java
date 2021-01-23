package clase2.tt.ejercicio2;

import org.junit.jupiter.api.Test;
import clase2.tt.ejercicio2.FiguraGeometrica.FiguraGeometricaException;

import static org.junit.jupiter.api.Assertions.*;

class FigurasGeometricasTest {

    @Test
    void testAreaDeUnCirculo () {
        FiguraGeometrica circulo = new Circulo(5.0);
        assertEquals(78.5d, circulo.area());
        FiguraGeometrica circulo2 = new Circulo(345.21);
        assertEquals(374383.4d, circulo2.area());
    }

    @Test
    void testAreaDeUnRectangulo () {
        FiguraGeometrica rectangulo = new Rectangulo(10, 2);
        assertEquals(20d, rectangulo.area());
        FiguraGeometrica rectangulo2 = new Rectangulo( 89.7,768.23);
        assertEquals(68910.2, rectangulo2.area());
    }

    @Test
    void testAreaDeUnTriangulo () {
        FiguraGeometrica triangulo = new Triangulo(39, 22.4);
        assertEquals(436.8d, triangulo.area());
        FiguraGeometrica triangulo2 = new Triangulo( 103.12,64);
        assertEquals(3299.8, triangulo2.area());
    }

    @Test
    void testInvalidAttributesValue () {
        assertThrows(FiguraGeometricaException.class, () -> new Circulo(-10));
        assertThrows(FiguraGeometricaException.class, () -> new Circulo(0));

        assertThrows(FiguraGeometricaException.class, () -> new Rectangulo(-10, 30));
        assertThrows(FiguraGeometricaException.class, () -> new Rectangulo(10, -30));
        assertThrows(FiguraGeometricaException.class, () -> new Rectangulo(0, 30));
        assertThrows(FiguraGeometricaException.class, () -> new Rectangulo(10, 0));

        assertThrows(FiguraGeometricaException.class, () -> new Triangulo(-10, 30));
        assertThrows(FiguraGeometricaException.class, () -> new Triangulo(10, -30));
        assertThrows(FiguraGeometricaException.class, () -> new Triangulo(0, 30));
        assertThrows(FiguraGeometricaException.class, () -> new Triangulo(10, 0));
    }

    @Test
    void testAreaPromedio() {
        FiguraGeometrica[] arr = new FiguraGeometrica[6];
        arr[0] = new Circulo(5.0);
        arr[1] = new Circulo(345.21);
        arr[2] = new Rectangulo(10, 2);
        arr[3] = new Rectangulo(89.7,768.23);
        arr[4] = new Triangulo(39, 22.4);
        arr[5] = new Triangulo(103.12,64);
        assertEquals(74521.5, FiguraGeometricaUtil.areaPromedio(arr));
    }
}