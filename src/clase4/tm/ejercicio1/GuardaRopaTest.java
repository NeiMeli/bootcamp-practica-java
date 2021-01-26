package clase4.tm.ejercicio1;

import common.CollectionTestUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRopaTest {
    @Test
    void testGuardarRopa() {
        GuardaRopa guardaRopa = new GuardaRopa();
        int contadorInicial = guardaRopa.getContador();
        assertEquals(0, contadorInicial);

        final Prenda nike5000 = new Prenda("Nike", "5000");
        final Prenda tommyTiJirt = new Prenda("Tommy", "ti-jirt");
        final Prenda gapBuso = new Prenda("GAP", "buso");
        final Prenda adidasA1 = new Prenda("Adidas", "a1");
        final Prenda hutGorra = new Prenda("Hut", "Gorra");

        // guardar ropa
        Integer num1 = guardaRopa.guardarPrendas(Arrays.asList(nike5000));
        assertEquals(contadorInicial + 1, num1);
        Integer num2 = guardaRopa.guardarPrendas(Arrays.asList(tommyTiJirt, gapBuso));
        assertEquals(num1 + 1, num2);
        Integer num3 = guardaRopa.guardarPrendas(Arrays.asList(adidasA1, hutGorra));
        assertEquals(num2 + 1, num3);

        // Errores
        // Guardar lista vacía debería tirar una excepción
        assertThrows(GuardaRopa.GuardaRopaException.class, () -> guardaRopa.guardarPrendas(Collections.emptyList()));
        // Retirar prendas con un número inválido debería tirar una excepción
        assertThrows(GuardaRopa.GuardaRopaException.class, () -> guardaRopa.devolverPrendas(-1));

        // Mostrar prendas
        guardaRopa.mostrarPrendas();

        // Devolver prendas, deberían salir del mapa
        List<Prenda> prendas = guardaRopa.devolverPrendas(num1);
        CollectionTestUtil.assertListsContainSameElements(prendas, Arrays.asList(nike5000));
        assertEquals(2, guardaRopa.getPrendas().size());
        List<Prenda> prendas2 = guardaRopa.devolverPrendas(num2);
        CollectionTestUtil.assertListsContainSameElements(prendas2, Arrays.asList(tommyTiJirt, gapBuso));
        assertEquals(1, guardaRopa.getPrendas().size());
        List<Prenda> prendas3 = guardaRopa.devolverPrendas(num3);
        CollectionTestUtil.assertListsContainSameElements(prendas3, Arrays.asList(adidasA1, hutGorra));
        assertEquals(0, guardaRopa.getPrendas().size());
    }
}