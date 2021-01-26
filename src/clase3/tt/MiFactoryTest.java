package clase3.tt;

import common.CollectionTestUtil;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MiFactoryTest {
    @Test
    void testMiFactoryFromCustomString() {
        Sorter<Integer> quickSorter = MiFactory.getInstance("clase3.tt.QuickSortSorterImple");
        assertEquals(QuickSortSorterImple.class, quickSorter.getClass());
        Sorter<Integer> heapSorter = MiFactory.getInstance("clase3.tt.HeapSortSorterImple");
        assertEquals(HeapSortSorterImple.class, heapSorter.getClass());
        Sorter<Integer> bubbleSorter = MiFactory.getInstance("clase3.tt.BubbleSortSorterImple");
        assertEquals(BubbleSortSorterImple.class, bubbleSorter.getClass());

        Integer[] sample = {5, 98, 23, 7, 233, 32, 3, 90, 14, 76};
        Comparator<Integer> ascendingComparator = (i1, i2) -> i1 - i2;
        CollectionTestUtil.Equable<Integer> equable = (t1, t2) -> t1.intValue() == t2.intValue();
        Integer[] expectedAscendingResult = {3, 5, 7, 14, 23, 32, 76, 90, 98, 233};

        Integer[] clone1 = sample.clone();
        Integer[] clone2 = sample.clone();
        Integer[] clone3 = sample.clone();

        quickSorter.sort(clone1, ascendingComparator);
        heapSorter.sort(clone2, ascendingComparator);
        bubbleSorter.sort(clone3, ascendingComparator);

        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, clone1, equable);
        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, clone2, equable);
        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, clone3, equable);
    }

    @Test
    void testMiFactoryFromCustomStringFail() {
        assertThrows(Exception.class, () -> MiFactory.getInstance("NonExistantSorter"));
    }

    @Test
    void testMiFactoryFromProperty() throws Exception {
        Properties prop = new Properties();
        InputStream inputStream = new FileInputStream("src/clase3/tt/MiFactory.properties");
        prop.load(inputStream);
        String className = prop.getProperty("sorter");

        Sorter<Integer> sorter = MiFactory.getInstance();
        assertEquals(className, sorter.getClass().getName());
    }
}
