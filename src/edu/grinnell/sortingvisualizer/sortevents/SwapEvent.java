package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;

public class SwapEvent<T> implements SortEvent<T> {
	
	private int n;
	private int k;
	
	public SwapEvent(int n, int k) {
		this.n = n;
		this.k = k;
	}
	
	public void apply(ArrayList<T> arr) {
		T temp = arr.get(n);
		arr.set(n, arr.get(k));
		arr.set(k, temp);
	}
	
	public ArrayList<Integer> getAffectedIndices() {
	    ArrayList<Integer> ret = new ArrayList<>();
        ret.add(n);
        ret.add(k);
        return ret;
	}
	
	public boolean isEmphasized() {
		return true;
	}

}
