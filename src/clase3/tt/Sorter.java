package clase3.tt;

import java.util.Comparator;

public interface Sorter <T> {
    void sort(T[] arr, Comparator<T> c);
    default void swap(T[] arr, int index1, int index2) {
        T aux = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = aux;
    }
}
