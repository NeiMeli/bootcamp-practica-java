package clase3.tm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtil {
    public static <T> List<T> ordenar (Precedable<T>[] arr) {
        return Arrays.stream(arr).sorted((p1, p2) -> p1.precedeA((T) p2)).map(p -> (T) p).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Persona persona3 = new Persona("c", 502);
        Persona persona1 = new Persona("a", 37);
        Persona persona4 = new Persona("d", 7002);
        Persona persona5 = new Persona("e", 8000);
        Persona persona2 = new Persona("b", 427);
        Precedable[] arr = new Precedable[]{persona3, persona1, persona4, persona5, persona2};
        System.out.println(ordenar(arr));
    }
}
