package clase1.tt;

import common.IOUtil;
import common.StringUtil;
import menu.MenuItem;

import java.util.*;
import java.util.stream.Collectors;

import static common.IOUtil.ensureIntInput;
import static common.IOUtil.print;

public class Clase1TTMain {
    public static void main(String[] args) {
        runExercise();
    }

    private static void runExercise() {
        final String prompt = "Ingrese números enteros. Para finalizar la carga ingrese 0. Se ordenarán los números de forma tal" +
                " que todos tendrán la misma cantidad de dígitos (agregando ceros) y se presenten de forma ascendente";
        List<Integer> numbers = Collections.emptyList();
        int intInput = ensureIntInput(prompt);
        while (intInput != 0) {
            if (numbers.isEmpty()) numbers = new ArrayList<>();
            numbers.add(intInput);
            intInput = ensureIntInput(prompt);
        }
        radixSort(numbers.stream().mapToInt(Integer::intValue).toArray());
    }

    private static void radixSort(int [] arr) {
        print(String.format("Ordenando {%s}", Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" - "))));
        Arrays.stream(applyRadixSort(arr)).forEach(IOUtil::print);
    }

    public static String[] applyRadixSort(int[] arr) {
        final String[] stringArray = StringUtil.toStringArray(arr);
        if (stringArray.length == 0) return stringArray;
        int finalLength = StringUtil.getMaxLenght(stringArray);
        String[] result = StringUtil.fill(stringArray, finalLength);

        for (int i = finalLength - 1; i >= 0; i --) {
            final Map<Integer, List<String>> stringArrayByDigitMap = StringUtil.toStringArrayByDigitMap(result, i);
            result = StringUtil.mapToStringArray(stringArrayByDigitMap);
        }
        return result;
    }

    public static MenuItem buildMenu() {
        return MenuItem.create("Turno Tarde - Radix Sort", Clase1TTMain::runExercise, false);
    }
}