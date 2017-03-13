package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;


public class Sorts {
	
	public static <T extends Comparable<T>> void swap(ArrayList<T> arr, int a, int b) {
		T temp = arr.get(a);
		arr.set(a,  arr.get(b));
		arr.set(b,  temp);
	}
	
	public static <T extends Comparable<T>> ArrayList<SortEvent> selectionSort(ArrayList<T> arr) {
		ArrayList<SortEvent> event = new ArrayList<SortEvent>(); //??
	for (int i = 0; i < arr.size(); i ++) {
		int index = i;
		for (int k = i + 1; k < arr.size(); k++) {
			SortEvent<T> compareEvent = new CompareEvent<T>(k, index);
			event.add(compareEvent);
			if(arr.get(k).compareTo(arr.get(index)) < 0) {
				index = k;
			}
		}
		SortEvent<T> swapEvent = new SwapEvent<T>(i, index);
		event.add(swapEvent);
		swap(arr, i, index);
			}
	return event;
		}

	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> arr) {

	}

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> arr) {
		List<SortEvent<T>> event = new ArrayList<>();
		mergeSortHelper(arr, 0, arr.size(), event);
		return event;
	}

	public static <T extends Comparable<T>> void mergeSortHelper(ArrayList<T> arr, int lo, int hi, List<SortEvent<T>> event) {
		if (hi - lo <= 1) {
			return;
		} else if (lo < hi) {
			int mid = (hi + lo) / 2;
			mergeSortHelper(arr, lo, mid, event);
			mergeSortHelper(arr, mid, hi, event);
			merge(arr, lo, mid, hi, event);
		}
	}

	public static <T extends Comparable<T>> void merge(ArrayList<T> arr, int lo, int mid, int hi, List<SortEvent<T>> event) {
		ArrayList<T> temp = new ArrayList<T>();
		int i = lo;
		int j = mid;
		while(i < mid && j < hi) {
			SortEvent<T> compare = new CompareEvent<T>(lo, mid);
			event.add(compare);
			if (arr.get(i).compareTo(arr.get(j)) < 0) {
				temp.add(arr.get(i));
				i++;
			} else {
				temp.add(arr.get(j));
				j++;
			}
		} while (i < mid) {
			temp.add(arr.get(j));
			j++;
		} while (j < hi) {
			temp.add(arr.get(j));
			j++;
		} for (int k = 0; k < temp.size(); k++) {
			arr.set(lo +k, temp.get(k));
		}
	}
	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
		// TODO: implement instrumented quickSort
		return null;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
		// TODO: implement your own custom sort
		return null;
	}

}
