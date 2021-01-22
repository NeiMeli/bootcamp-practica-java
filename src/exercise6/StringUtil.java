package exercise6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

// Volví a armar la clase con los métodos solicitados
public class StringUtil {

    private static final char BLANK = ' ';

    public static String ltrim(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == BLANK)
            index ++;
        return s.substring(index);
    }

    public static String rtrim(String s) {
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index > 0 && chars[index] == BLANK)
            index --;
        return s.substring(0, index + 1);
    }

    public static String trim(String s) {
        return ltrim(rtrim(s));
    }

    public static int indexOfN(String s,char c,int n) {
        char[] chars = s.toCharArray();
        List<Integer> matchingIndexes = Collections.emptyList();
        int index = 0;
        while (index < chars.length && matchingIndexes.size() < n) {
            if (chars[index] == c) {
                if (matchingIndexes.isEmpty()) matchingIndexes = new ArrayList<>();
                matchingIndexes.add(index);
            }
            index ++;
        }
        return matchingIndexes.size() >= n ? matchingIndexes.get(n - 1) : -1;
    }

    public static String rpad(String s,char c,int n) {
        return applyNTimes(n, s, string -> string += c);
    }

    public static String lpad(String s,final char c,int n) {
        return applyNTimes(n, s, string ->  c + string);
    }

    public static String applyNTimes(int n, String string, Function<String, String> action) {
        String result = string;
        for (int i = 0; i < n; i ++) {
            result = action.apply(result);
        }
        return result;
    }
}
