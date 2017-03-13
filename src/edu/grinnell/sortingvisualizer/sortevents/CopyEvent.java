package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{

	public ArrayList<T> list;
	public List<Integer> indices;
	
	public CopyEvent(T val, int n) { //?
		indices = new ArrayList<Integer>();
		indices.add(n);
	}
	
	public void apply(ArrayList<T> arr) {
		arr.add(list.get(indices.get(0)));	//??
	}

	public List<Integer> getAffectedIndices() {
		return null;
	}

	public boolean isEmphasized() {
		return true;
	}
	

}
