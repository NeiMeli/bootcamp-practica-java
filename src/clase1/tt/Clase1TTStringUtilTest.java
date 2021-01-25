package clase1.tt;

import common.StringUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static common.CollectionTestUtil.assertArraysContainSameElements;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Clase1TTStringUtilTest {

    @Test
    void testFill() {
        final String[] sortedByLengthUnfilledStrings = StringUtil.toStringArray(StringUtilTestConstants.INT_UNSORTED_UNFILLED_1);
        final String[] sortedByLengthFilledStrings = StringUtil.fill(sortedByLengthUnfilledStrings, 3);
        assertArraysContainSameElements(StringUtilTestConstants.STRING_UNSORTED_FILLED_1, sortedByLengthFilledStrings);
    }

    @Test
    void testToSortedByLengthStringArray() {
        final String[] sortedByLengthUnfilledStrings = StringUtil.toStringArray(StringUtilTestConstants.INT_UNSORTED_UNFILLED_1);
        assertArraysContainSameElements(StringUtilTestConstants.STRING_UNSORTED_UNFILLED_1, sortedByLengthUnfilledStrings);
    }

    @Test
    void testToStringArrayByDigitMap() {
        String[] sortedByLengthStringArray = StringUtil.toStringArray(StringUtilTestConstants.INT_UNSORTED_UNFILLED_2);
        String[] filledArray = StringUtil.fill(sortedByLengthStringArray, 3);
        Map<Integer, List<String>> stringArrayByDigitMap = StringUtil.toStringArrayByDigitMap(filledArray, 2);
        assertEquals(stringArrayByDigitMap.size(), 4);
        assertTrue(stringArrayByDigitMap.containsKey(3));
        assertTrue(stringArrayByDigitMap.containsKey(2));
        assertEquals(stringArrayByDigitMap.get(3).size(), 3);
        assertTrue(stringArrayByDigitMap.get(3).containsAll(Arrays.asList("003", "023", "673")));
    }
}
