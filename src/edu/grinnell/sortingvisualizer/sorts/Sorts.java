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
		List<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		for (int i = 0; i < arr.size() - 1; i++) {
			SortEvent<T> compareEvent = new CompareEvent<T>(i, arr.size());
			event.add(compareEvent);
			int index = i;
			for (int k = i + 1; k < arr.size(); k++) {
				SortEvent<T> compareEvent1 = new CompareEvent<T>(k, arr.size());
				event.add(compareEvent1);
				SortEvent<T> compareEvent2 = new CompareEvent<T>(k, index);
				event.add(compareEvent2);
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
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(ArrayList<T> arr) {
		List<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		for (int i = 0; i < arr.size(); i++) {
			SortEvent<T> compareEvent = new CompareEvent<T>(i, arr.size());
			event.add(compareEvent);
			for (int k = i; k > 0; k--) {
				SortEvent<T> compareEvent1 = new CompareEvent<T>(k, 0);
				event.add(compareEvent1);
				SortEvent<T> compareEvent2 = new CompareEvent<T>(k - 1, k);
				event.add(compareEvent2);
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
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(ArrayList<T> arr) {
		List<SortEvent<T>> event = new ArrayList<>();
		mergeSortHelper(arr, 0, arr.size(), event);
		return event;
	}

	public static <T extends Comparable<T>> void mergeSortHelper(ArrayList<T> arr, int lo, int hi,
			List<SortEvent<T>> event) {
		SortEvent<T> compareEvent = new CompareEvent<T>(hi - lo, 1);
		event.add(compareEvent);
		if (hi - lo <= 1) {
			return;
		}
		SortEvent<T> compareEvent2 = new CompareEvent<T>(lo, hi);
		event.add(compareEvent2);
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
			SortEvent<T> compare = new CompareEvent<T>(i, mid);
			event.add(compare);
			SortEvent<T> compare1 = new CompareEvent<T>(j, hi);
			event.add(compare1);
			SortEvent<T> compare2 = new CompareEvent<T>(i, j);
			event.add(compare2);
			if (arr.get(i).compareTo(arr.get(j)) < 0) {
				temp.add(arr.get(i));
				i++;
			} else {
				temp.add(arr.get(j));
				j++;
			}
		}
		while (i < mid) {
			SortEvent<T> compare3 = new CompareEvent<T>(i, mid);
			event.add(compare3);
			temp.add(arr.get(i));
			i++;
		}
		while (j < hi) {
			SortEvent<T> compare4 = new CompareEvent<T>(j, hi);
			event.add(compare4);
			temp.add(arr.get(j));
			j++;
		}
		for (int k = 0; k < temp.size(); k++) {
			SortEvent<T> compare5 = new CompareEvent<T>(k, temp.size());
			event.add(compare5);
			SortEvent<T> copyEvent = new CopyEvent<T>(lo + k, temp.get(k));
			event.add(copyEvent);
			arr.set(lo + k, temp.get(k));
		}
	}

	// quickSort
	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(ArrayList<T> arr) {
		List<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		quickSortHelper(arr, 0, arr.size() - 1, event);
		return event;
	}

	public static <T extends Comparable<T>> int partition(ArrayList<T> l, int lo, int hi, int pivotIndex,
			List<SortEvent<T>> event) {
		{
			SortEvent<T> swapEvent = new SwapEvent<T>(pivotIndex, hi);
			event.add(swapEvent);
			swap(l, pivotIndex, hi);
			int j = hi;
			int i = lo;

			while (i != j) {
				{
					SortEvent<T> compare = new CompareEvent<T>(i, j);
					event.add(compare);
					while (l.get(i).compareTo(l.get(hi)) < 0) {
						SortEvent<T> compare2 = new CompareEvent<T>(i, hi);
						event.add(compare2);
						i++;
					}
					while (i != j && l.get(j).compareTo(l.get(hi)) >= 0) {
						SortEvent<T> compare3 = new CompareEvent<T>(j, i);
						event.add(compare3);
						SortEvent<T> compare4 = new CompareEvent<T>(j, hi);
						event.add(compare4);
						j--;
					}
					SortEvent<T> swapEvent1 = new SwapEvent<T>(i, j);
					event.add(swapEvent1);
					swap(l, i, j);
				}
			}
			SortEvent<T> swapEvent2 = new SwapEvent<T>(hi, i);
			event.add(swapEvent2);
			swap(l, hi, i);
			return i;
		}
	}

	public static <T extends Comparable<T>> void quickSortHelper(ArrayList<T> arr, int lo, int hi,
			List<SortEvent<T>> event) {
		if (lo >= hi) {
			SortEvent<T> compare = new CompareEvent<T>(lo, hi);
			event.add(compare);
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
		List<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		for (int i = 0; i < l.size(); i++) {
			SortEvent<T> compare = new CompareEvent<T>(i, l.size());
			event.add(compare);
			for (int j = 1; j < l.size() - i; j++) {
				SortEvent<T> compare1 = new CompareEvent<T>(j, l.size());
				event.add(compare1);
				SortEvent<T> compare2 = new CompareEvent<T>(j - 1, j);
				event.add(compare2);
				if ((l.get(j - 1).compareTo(l.get(j)) > 0)) {
					SortEvent<T> swapEvent = new SwapEvent<T>(j - 1, j);
					event.add(swapEvent);
					swap(l, j - 1, j);
				}
			}
		}
		return event;
	}

	// shellSort
	public static <T extends Comparable<T>> List<SortEvent<T>> shellSort(ArrayList<T> l) {
		List<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		int j;
		for (int gap = l.size() / 2; gap > 0; gap /= 2) {
			SortEvent<T> compare = new CompareEvent<T>(gap, 0);
			event.add(compare);
			for (int i = gap; i < l.size(); i++) {
				SortEvent<T> compare1 = new CompareEvent<T>(i, l.size());
				event.add(compare1);
				T temp = l.get(i);
				for (j = i; j >= gap && temp.compareTo(l.get(j - gap)) < 0; j -= gap) {
					SortEvent<T> compare2 = new CompareEvent<T>(j, gap);
					event.add(compare2);
					SortEvent<T> compare3 = new CompareEvent<T>(i, j - gap);
					event.add(compare3);
					SortEvent<T> copy = new CopyEvent<T>(j, l.get(j - gap));
					event.add(copy);
					l.set(j, l.get(j - gap));
				}
				SortEvent<T> copy1 = new CopyEvent<T>(j, l.get(i));
				event.add(copy1);
				l.set(j, temp);
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