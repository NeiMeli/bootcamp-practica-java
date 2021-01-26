package clase3.tt;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int length = arr.length;
        for (int i = 0; i < length-1; i++)
            for (int j = 0; j < length-i-1; j++)
                if (c.compare(arr[j],arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
    }
}
