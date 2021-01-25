package clase3.tt;

import clase2.tm.ejercicio1.CuentaCorriente;
import common.CollectionTestUtil;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class SorterImplementationsTest {
    @Test
    void testSortIntegers() {
        Integer[] sample = {5, 98, 23, 7, 233, 32, 3, 90, 14, 76};
        QuickSortSorterImple<Integer> integerSorter = new QuickSortSorterImple<>();
        CollectionTestUtil.Equable<Integer> equable = (t1, t2) -> t1.intValue() == t2.intValue();

        Comparator<Integer> ascendingComparator = (i1, i2) -> i1 - i2;
        Integer[] expectedAscendingResult = {3, 5, 7, 14, 23, 32, 76, 90, 98, 233};
        Integer[] arr1 = sample.clone();
        integerSorter.sort(arr1, ascendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, arr1, equable);

        Comparator<Integer> descendingComparator = (i1, i2) -> i2 - i1;
        Integer[] expectedDescendingResult = {233, 98, 90, 76, 32, 23, 14, 7, 5, 3};
        Integer[] arr2 = sample.clone();
        integerSorter.sort(arr2, descendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedDescendingResult, arr2, equable);
    }

    @Test
    void testSortStrings() {
        String[] sample = {"Pedro", "Eugenia", "Acasio", "Ana", "Francisco", "Luis"};
        QuickSortSorterImple<String> stringSorter = new QuickSortSorterImple<>();

        Comparator<String> ascendingComparator = (i1, i2) -> i1.length() - i2.length();
        String[] expectedAscendingResult = {"Ana", "Luis", "Pedro", "Acasio", "Eugenia", "Francisco"};
        String[] arr1 = sample.clone();
        stringSorter.sort(arr1, ascendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, arr1);

        Comparator<String> descendingComparator = (i1, i2) -> i2.length() - i1.length();
        String[] expectedDescendingResult = {"Francisco", "Eugenia", "Acasio", "Pedro", "Luis", "Ana"};
        String[] arr2 = sample.clone();
        stringSorter.sort(arr2, descendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedDescendingResult, arr2);
    }

    @Test
    void testSortCuentasCorrientes() {
        CuentaCorriente[] sample = {
                new CuentaCorriente(500),
                new CuentaCorriente(350),
                new CuentaCorriente(90),
                new CuentaCorriente(1000),
                new CuentaCorriente(800),
                new CuentaCorriente()
        };
        QuickSortSorterImple<CuentaCorriente> ccSorter = new QuickSortSorterImple<>();
        CollectionTestUtil.Equable<CuentaCorriente> equable = (t1, t2) -> t1.getSaldo() == t2.getSaldo();

        Comparator<CuentaCorriente> ascendingComparator = (c1, c2) -> (int) (c1.getSaldo() - c2.getSaldo());
        CuentaCorriente[] expectedAscendingResult = {
                new CuentaCorriente(),
                new CuentaCorriente(90),
                new CuentaCorriente(350),
                new CuentaCorriente(500),
                new CuentaCorriente(800),
                new CuentaCorriente(1000)
        };
        CuentaCorriente[] arr1 = sample.clone();
        ccSorter.sort(arr1, ascendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedAscendingResult, arr1, equable);

        Comparator<CuentaCorriente> descendingComparator = (c1, c2) -> (int) (c2.getSaldo() - c1.getSaldo());
        CuentaCorriente[] expectedDescendingResult = {
                new CuentaCorriente(1000),
                new CuentaCorriente(800),
                new CuentaCorriente(500),
                new CuentaCorriente(350),
                new CuentaCorriente(90),
                new CuentaCorriente()
        };
        CuentaCorriente[] arr2 = sample.clone();
        ccSorter.sort(arr2, descendingComparator);
        CollectionTestUtil.assertArraysContainSameElements(expectedDescendingResult, arr2, equable);
    }
}