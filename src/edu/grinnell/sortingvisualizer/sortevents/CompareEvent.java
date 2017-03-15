package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;


public class CompareEvent<T extends Comparable<T>> implements SortEvent<T> {

	private int n;
	private int k;
	
	public CompareEvent(int n, int k) {
		this.n = n;
		this.k = k;
	}
	
	public void apply(ArrayList<T> arr) {
		arr.get(n).compareTo(arr.get(k));
	}

	public ArrayList<Integer> getAffectedIndices() {
	    ArrayList<Integer> ret = new ArrayList<>();
        ret.add(n);
        ret.add(k);
        return ret;
	}

	public boolean isEmphasized() {
		return false;
	}

}
