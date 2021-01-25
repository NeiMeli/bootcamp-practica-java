package clase3.tm;

import common.CollectionTestUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static clase3.tm.SortUtil.ordenar;
import static common.CollectionTestUtil.assertListsContainSameElements;

class SortUtilTest {

    @Test
    void testOrdenarPersonas() {
        Persona persona1 = new Persona("a", 37);
        Persona persona2 = new Persona("b", 427);
        Persona persona3 = new Persona("c", 502);
        Persona persona4 = new Persona("d", 7002);
        Persona persona5 = new Persona("e", 8000);

        Precedable<Persona>[] arr = new Precedable[] {persona3, persona1, persona4, persona5, persona2};
        List<Persona> expected = Arrays.asList(persona1, persona2, persona3, persona4, persona5);

        final List<Persona> actual = ordenar(arr);
        assertListsContainSameElements(expected, actual);
    }

    @Test
    void testOrdenarCelular() {
        Celular celular1 = new Celular(156182, "a");
        Celular celular2 = new Celular(156890, "b");
        Celular celular3 = new Celular(157762, "c");
        Celular celular4 = new Celular(157765, "d");
        Celular celular5 = new Celular(159867, "e");

        Precedable<Celular>[] arr = new Precedable[] {celular3, celular1, celular4, celular5, celular2};
        List<Celular> expected = Arrays.asList(celular1, celular2, celular3, celular4, celular5);

        final List<Celular> actual = ordenar(arr);
        assertListsContainSameElements(expected, actual);
    }
}