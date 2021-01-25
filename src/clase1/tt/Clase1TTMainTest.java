package clase1.tt;

import org.junit.jupiter.api.Test;

import static common.CollectionTestUtil.assertArraysContainSameElements;

class Clase1TTMainTest {
    @Test
    void applyRadixSortCase1() {
        final String[] result = Clase1TTMain.applyRadixSort(StringUtilTestConstants.INT_UNSORTED_UNFILLED_1);
        assertArraysContainSameElements(StringUtilTestConstants.STRING_SORTED_BY_DIGIT_FILLED_1, result);
    }

    @Test
    void applyRadixSortCase2() {
        final String[] result = Clase1TTMain.applyRadixSort(StringUtilTestConstants.INT_UNSORTED_UNFILLED_2);
        assertArraysContainSameElements(StringUtilTestConstants.STRING_SORTED_BY_DIGIT_FILLED_2, result);
    }
}