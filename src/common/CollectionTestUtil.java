package common;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTestUtil {
    public static <T> void assertArraysContainSameElements(T[] expected, T[] actual) {
        assertArraysContainSameElements(expected, actual, Object::equals);
    }
    public static <T> void assertArraysContainSameElements(T[] expected, T[] actual, Equable<T> equable) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i ++) {
            assertTrue(equable.areEqual(expected[i], actual[i]));
        }
    }

    public static <T> void assertListsContainSameElements(List<T> expected, List<T> actual) {
        assertListsContainSameElements(expected, actual, Object::equals);
    }

    public static <T> void assertListsContainSameElements(List<T> expected, List<T> actual, Equable<T> equable) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i ++) {
            assertTrue(equable.areEqual(expected.get(i), actual.get(i)));
        }
    }

    @FunctionalInterface
    public interface Equable<T> {
        boolean areEqual(T t1, T t2);
    }
}
