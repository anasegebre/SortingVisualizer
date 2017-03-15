package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class Sorts {

    public static <T extends Comparable<T>> void swap(ArrayList<T> arr, int a, int b) {
        T temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    // selectionSort
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(ArrayList<T> arr) {
        List<SortEvent<T>> event = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            int index = i;
            for (int k = i + 1; k < arr.size(); k++) {
                event.add(new CompareEvent<>(k, index));
                if (arr.get(k).compareTo(arr.get(index)) < 0) {
                    index = k;
                }
            }
            event.add(new SwapEvent<>(i, index));
            swap(arr, i, index);
        }
        return event;
    }

    // insertionSort
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> arr) {
        List<SortEvent<T>> event = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int k = i; k > 0; k--) {
                event.add(new CompareEvent<T>(k - 1, k));
                if (arr.get(k - 1).compareTo(arr.get(k)) > 0) {
                    event.add(new SwapEvent<T>(k - 1, k));
                    swap(arr, k - 1, k);
                }
            }
        }
        return event;
    }

    // mergeSort
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> arr) {
        List<SortEvent<T>> event = new ArrayList<>();
        mergeSortHelper(arr, 0, arr.size(), event);
        return event;
    }

    public static <T extends Comparable<T>> void mergeSortHelper(ArrayList<T> arr, int lo, int hi,
            List<SortEvent<T>> event) {
        if (hi - lo <= 1) {
            return;
        }
        if (lo < hi) {
            int mid = (hi + lo) / 2;
            mergeSortHelper(arr, lo, mid, event);
            mergeSortHelper(arr, mid, hi, event);
            merge(arr, lo, mid, hi, event);
        }
    }

    public static <T extends Comparable<T>> void merge(ArrayList<T> arr, int lo, int mid, int hi,
            List<SortEvent<T>> event) {
        ArrayList<T> temp = new ArrayList<T>();
        int i = lo;
        int j = mid;
        while (i < mid && j < hi) {
            event.add(new CompareEvent<T>(i, j));
            if (arr.get(i).compareTo(arr.get(j)) < 0) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }
        while (i < mid) {
            temp.add(arr.get(i));
            i++;
        }
        while (j < hi) {
            temp.add(arr.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            event.add(new CopyEvent<T>(lo + k, temp.get(k)));
            arr.set(lo + k, temp.get(k));
        }
    }

    // quickSort
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> arr) {
        List<SortEvent<T>> event = new ArrayList<>();
        quickSortHelper(arr, 0, arr.size() - 1, event);
        return event;
    }

    public static <T extends Comparable<T>> int partition(ArrayList<T> l, int lo, int hi, int pivotIndex,
            List<SortEvent<T>> event) {
        {
            event.add(new SwapEvent<T>(pivotIndex, hi));
            swap(l, pivotIndex, hi);
            int j = hi;
            int i = lo;

            while (i != j) {
                {
                    while (l.get(i).compareTo(l.get(hi)) < 0) {
                        event.add(new CompareEvent<T>(i, hi));
                        i++;
                    }
                    while (i != j && l.get(j).compareTo(l.get(hi)) >= 0) {
                        event.add(new CompareEvent<T>(j, hi));
                        j--;
                    }
                    event.add(new SwapEvent<T>(i, j));
                    swap(l, i, j);
                }
            }
            event.add(new SwapEvent<T>(hi, i));
            swap(l, hi, i);
            return i;
        }
    }

    public static <T extends Comparable<T>> void quickSortHelper(ArrayList<T> arr, int lo, int hi,
            List<SortEvent<T>> event) {
        if (lo >= hi) {
            return;
        } else {
            Random rand = new Random();
            int pivotIndex = rand.nextInt(hi - lo) + lo;
            int mid = partition(arr, lo, hi, pivotIndex, event);
            quickSortHelper(arr, lo, mid - 1, event);
            quickSortHelper(arr, mid + 1, hi, event);

        }
    }

    // bubbleSort
    public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(ArrayList<T> l) {
        List<SortEvent<T>> event = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            for (int j = 1; j < l.size() - i; j++) {
                event.add(new CompareEvent<T>(j - 1, j));
                if ((l.get(j - 1).compareTo(l.get(j)) > 0)) {
                    event.add(new SwapEvent<T>(j - 1, j));
                    swap(l, j - 1, j);
                }
            }
        }
        return event;
    }

    // shellSort
    public static <T extends Comparable<T>> List<SortEvent<T>> shellSort(ArrayList<T> l) {
        List<SortEvent<T>> event = new ArrayList<>();
        int j;
        for (int gap = l.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < l.size(); i++) {
                if (l.get(i).compareTo(l.get(i - gap)) < 0) {
                    event.add(new CompareEvent<T>(i, i - gap));
                    event.add(new SwapEvent<T>(i, i - gap));
                    swap(l, i, i - gap);
                }
                for (j = i - gap; j >= gap; j -= gap) {
                    if (l.get(j).compareTo(l.get(j - gap)) < 0) {
                        event.add(new CompareEvent<T>(j, j - gap));
                        event.add(new SwapEvent<T>(j, j - gap));
                        swap(l, j, j - gap);
                    }
                }
            }
        }
        return event;
    }

    // eventSort
    public static <T> void eventSort(ArrayList<T> l, List<SortEvent<T>> events) {
        for (int i = 0; i < events.size(); i++) {
            events.get(i).apply(l);
        }
    }

}