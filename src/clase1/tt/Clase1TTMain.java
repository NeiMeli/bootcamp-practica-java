package clase1.tt;

import common.StringUtil;

import java.util.List;
import java.util.Map;

public class Clase1TTMain {
    public static void main(String[] args) {
        print("\nOrdenando {4, 28, 132, 3, 61, 5}:");
        radixSort(new int[]{4, 28, 132, 3, 61, 5});

        print("\nOrdenando {3, 673, 106, 45, 2, 23}:");
        radixSort(new int[]{3, 673, 106, 45, 2, 23});

        print("\nOrdenando {892, 1002, 16, 5, 239, 12, 98, 115, 7}:");
        radixSort(new int[]{892, 1002, 16, 5, 239, 12, 98, 115, 7});
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void radixSort(int [] arr) {
        for (String s : applyRadixSort(arr)) {
            print(s);
        }
    }

    public static String[] applyRadixSort(int[] arr) {
        final String[] sortedByLengthStringArray = StringUtil.toSortedByLengthStringArray(arr);
        if (sortedByLengthStringArray.length == 0) return sortedByLengthStringArray;
        int finalLength = sortedByLengthStringArray[0].length();
        String[] result = StringUtil.fill(sortedByLengthStringArray, finalLength);

        for (int i = finalLength - 1; i >= 0; i --) {
            final Map<Integer, List<String>> stringArrayByDigitMap = StringUtil.toStringArrayByDigitMap(result, i);
            result = StringUtil.mapToStringArray(stringArrayByDigitMap);
        }
        return result;
    }
}