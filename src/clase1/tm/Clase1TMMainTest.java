package clase1.tm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class Clase1TMMainTest {
    @Test public void testIsEven() {
        assertTrue(Clase1TMMain.isEven(2));
        assertTrue(Clase1TMMain.isEven(806));
        assertFalse(Clase1TMMain.isEven(3));
        assertFalse(Clase1TMMain.isEven(1897));
    }

    @Test public void testAreEvenDivisable() {
        assertTrue(Clase1TMMain.areEvenDivisible(4, 2));
        assertTrue(Clase1TMMain.areEvenDivisible(5088, 48));
        assertFalse(Clase1TMMain.areEvenDivisible(5, 3));
        assertFalse(Clase1TMMain.areEvenDivisible(1897, 200));
    }

    @Test public void testGetNNumbersThatHasMTimesD() {
        List<Integer> first = Clase1TMMain.getFirstNIntegersThatHaveMTimesD(5, 2, 3);
        assertEquals(5, first.size());
        assertTrue(first.containsAll(Arrays.asList(33, 133, 233, 303, 313)));

        List<Integer> second = Clase1TMMain.getFirstNIntegersThatHaveMTimesD(7, 2, 2);
        assertEquals(7, second.size());
        assertTrue(second.containsAll(Arrays.asList(22, 122, 202, 212, 220, 221, 222)));
    }
}