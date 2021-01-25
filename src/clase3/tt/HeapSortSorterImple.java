package clase3.tt;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class HeapSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int total = arr.length - 1;
        for (int i = total/2; i >= 0; i --) {
            heapify(arr, i, c, total);
        }
        for (int i = total; i > 0; i --) {
            swap(arr, 0, i);
            total--;
            heapify(arr, 0, c, total);
        }
    }

    private void heapify(T[] arr, int index, Comparator<T> c, int total) {
        int leftChildIndex = index * 2;
        Supplier<T> leftChild = () -> arr[leftChildIndex];
        int rightChildIndex = index * 2 + 1;
        Supplier<T> rightChild = () -> arr[rightChildIndex];
        final AtomicInteger maxIndex = new AtomicInteger(index);
        Supplier<T> max = () -> arr[maxIndex.get()];

        if (leftChildIndex <= total && c.compare(leftChild.get(), max.get()) >= 0) maxIndex.set(leftChildIndex);
        if (rightChildIndex <= total && c.compare(rightChild.get(), max.get()) >= 0) maxIndex.set(rightChildIndex);
        if (maxIndex.get() != index) {
            swap(arr, index, maxIndex.get());
            heapify(arr, maxIndex.get(), c, total);
        }
    }
}
