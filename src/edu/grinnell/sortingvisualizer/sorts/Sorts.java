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
    public static <T extends Comparable<T>> ArrayList<SortEvent<T>> selectionSort(ArrayList<T> arr) {
        ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
        for (int i = 0; i < arr.size() - 1; i++) {
            int index = i;
            for (int k = i + 1; k < arr.size(); k++) {
                SortEvent<T> compareEvent = new CompareEvent<T>(k, index);
                event.add(compareEvent);
                if (arr.get(k).compareTo(arr.get(index)) < 0) {
                    index = k;
                }
            }
            SortEvent<T> swapEvent = new SwapEvent<T>(i, index);
            event.add(swapEvent);
            swap(arr, i, index);
        }
        return event;
    }

    // insertionSort
    public static <T extends Comparable<T>> ArrayList<SortEvent<T>> insertionSort(ArrayList<T> arr) {
        ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
        for (int i = 0; i < arr.size(); i++) {
            for (int k = i; k > 0; k--) {
                SortEvent<T> compareEvent = new CompareEvent<T>(k - 1, k);
                event.add(compareEvent);
                if (arr.get(k - 1).compareTo(arr.get(k)) > 0) {
                    SortEvent<T> swapEvent = new SwapEvent<T>(k - 1, k);
                    event.add(swapEvent);
                    swap(arr, k - 1, k);
                }
            }
        }
        return event;
    }

    // mergeSort
    public static <T extends Comparable<T>> ArrayList<SortEvent<T>> mergeSort(ArrayList<T> arr) {
        ArrayList<SortEvent<T>> event = new ArrayList<>();
        mergeSortHelper(arr, 0, arr.size(), event);
        return event;
    }

    public static <T extends Comparable<T>> void mergeSortHelper(ArrayList<T> arr, int lo, int hi,
            List<SortEvent<T>> event) {
        if (hi - lo <= 1) {
            return;
        } else if (lo < hi) {
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
            SortEvent<T> compare = new CompareEvent<T>(lo, mid);
            event.add(compare);
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
            arr.set(lo + k, temp.get(k));
        }
    }

    // quickSort
    public static <T extends Comparable<T>> ArrayList<SortEvent<T>> quickSort(ArrayList<T> arr) {
        ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
        quickSortHelper(arr, 0, arr.size() - 1, event);
        return event;
    }

    public static <T extends Comparable<T>> int partition(ArrayList<T> l, int lo, int hi, int pivotIndex) {
        {
            swap(l, pivotIndex, hi);
            int j = hi;
            int i = lo;

            while (i != j) {
                {
                    while (l.get(i).compareTo(l.get(hi)) < 0) {
                        i++;
                    }
                    while (i != j && l.get(j).compareTo(l.get(hi)) >= 0) {
                        j--;
                    }
                    swap(l, i, j);
                }
            }
            swap(l, hi, i);
            return i;
        }
    }

    public static <T extends Comparable<T>> void quickSortHelper(ArrayList<T> arr, int lo, int hi,
            ArrayList<SortEvent<T>> event) {
        if (lo >= hi) { // ?? == or >=
            return;
        } else {
            Random rand = new Random();
            int pivotIndex = rand.nextInt(hi - lo) + lo;
            int mid = partition(arr, lo, hi, pivotIndex);
            quickSortHelper(arr, lo, mid - 1, event);
            quickSortHelper(arr, mid + 1, hi, event);

        }
    }

    // bubbleSort
    public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> l) {
        T temp;
        for (int i = 0; i < l.size(); i++) {
            for (int j = 1; j < l.size() - i; j++)
                if ((l.get(j - 1).compareTo(l.get(j)) > 0)) {
                    temp = l.get(j - 1);
                    l.set(j - 1, l.get(j));
                    l.set(j, temp);
                }
        }
    }

    // shellSort
    public static <T extends Comparable<T>> void shellSort(ArrayList<T> l) {
        int j;
        for (int gap = l.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < l.size(); i++) {
                T temp = l.get(i);
                for (j = i; j >= gap && temp.compareTo(l.get(j - gap)) < 0; j -= gap) {
                    l.set(j, l.get(j - gap));
                }
                l.set(j, temp);
            }
        }
    }

}
