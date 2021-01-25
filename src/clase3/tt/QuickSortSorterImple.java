package clase3.tt;

import java.util.Comparator;
import java.util.Random;

public class QuickSortSorterImple<T> implements Sorter<T> {
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quickSort(arr, 0, arr.length -1, c);
    }

    private void quickSort(T[] arr, int low, int high, Comparator<T> c) {
        if (low < high + 1) {
            int p = partition(arr, low, high, c);
            quickSort(arr, low, p - 1, c);
            quickSort(arr, p + 1, high, c);
        }
    }

    private int generateRandomPivot(int low, int high) {
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }

    private int partition(T[] arr, int low, int high, Comparator<T> c) {
        swap(arr, low, generateRandomPivot(low, high));
        int index = low + 1;
        for (int i = index; i <= high; i ++) {
            if (c.compare(arr[i], arr[low]) < 0) {
                swap(arr, i, index ++);
            }
        }
        swap(arr, low, index - 1);
        return index -1;
    }
}
