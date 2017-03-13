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
		arr.set(a,  arr.get(b));
		arr.set(b,  temp);
	}

	public static <T extends Comparable<T>> ArrayList<SortEvent<T>> selectionSort(ArrayList<T> arr) {
		ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
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

	public static <T extends Comparable<T>> ArrayList<SortEvent<T>> insertionSort(ArrayList<T> arr) {
		ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		for (int i = 0; i < arr.size(); i++) {
			for(int k = i; k > 0; k--) {
				SortEvent<T> compareEvent = new CompareEvent<T>(k - 1, k);
				event.add(compareEvent);
				if(arr.get(k - 1).compareTo(arr.get(k)) > 0) {
					SortEvent<T> swapEvent = new SwapEvent<T>(k - 1, k);
					event.add(swapEvent);
					swap(arr, k - 1, k);
				}
			}
		}
		return event;
	}

	public static <T extends Comparable<T>> ArrayList<SortEvent<T>> mergeSort(ArrayList<T> arr) {
		ArrayList<SortEvent<T>> event = new ArrayList<>();
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

	private static <T extends Comparable<T>> int partition(ArrayList<T> arr, int lo, int hi, int pivotIndex, ArrayList<SortEvent<T>> event) {
		SortEvent<T> swapEvent = new SwapEvent<T>(lo + pivotIndex, hi);
		event.add(swapEvent);
		swap(arr, lo + pivotIndex, hi);
		int i = lo;
		int  j = hi - 1;
		while(i <= j) {
			while(arr.get(i).compareTo(arr.get(hi)) < 0) {
				SortEvent<T> compareEvent = new CompareEvent<T>(i, hi);
				event.add(compareEvent);
				i++;
				if(i > (hi - 1)) {
					break;
				}
			}
			SortEvent<T> compareEvent = new CompareEvent<T>(i, hi);
			event.add(compareEvent);
			while(arr.get(j).compareTo(arr.get(hi)) > 0) {
				compareEvent = new CompareEvent<T>(j, hi);
				j--;
				if (j < lo) {
					break;
				}
			}
			compareEvent = new CompareEvent<T>(j, hi);
			event.add(compareEvent);
			if (j >= i) {
				swapEvent = new SwapEvent<T>(i++, hi--);
				event.add(swapEvent);
				swap(arr, i++, j--);
			}
		}
		swapEvent = new SwapEvent<T>(i, hi);
		event.add(swapEvent);
		swap(arr, i, hi);
		return i;
	}
	public static <T extends Comparable<T>> void quickSortHelper(ArrayList<T> arr, int lo, int hi, ArrayList<SortEvent<T>> event) {
		if (lo == hi) { //?? == or >=
			return; 
		} else {
			Random rand = new Random();
			int pivotIndex = rand.nextInt(hi - lo) + lo;
			int mid = partition(arr, lo, hi, pivotIndex, event);
			quickSortHelper(arr, lo, mid - 1, event);
			quickSortHelper(arr, mid + 1, hi, event);

		}
	}

	public static <T extends Comparable<T>> ArrayList<SortEvent<T>> quickSort(ArrayList<T> arr) {
		ArrayList<SortEvent<T>> event = new ArrayList<SortEvent<T>>();
		quickSortHelper(arr, 0, arr.size() - 1, event);
		return event;
	}
	public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
		// TODO: implement your own custom sort
		return null;
	}

}
