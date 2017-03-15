package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;


public class CopyEvent<T> implements SortEvent<T>{

	private int i;
	private T value;
	
	public CopyEvent(int i, T value) {
		this.i = i;
		this.value = value;
	}
	
	public void apply(ArrayList<T> arr) {
		arr.set(i, value);
	}

	public ArrayList<Integer> getAffectedIndices() {
		ArrayList<Integer> ret = new ArrayList<>();
		ret.add(i);
		return ret;
	}

	public boolean isEmphasized() {
		return true;
	}
	

}
