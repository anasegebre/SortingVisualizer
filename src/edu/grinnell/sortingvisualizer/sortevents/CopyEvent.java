package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{

	public ArrayList<T> list;
	public List<Integer> indices;
	
	public CopyEvent(int index, T element) {
		indices = new ArrayList<Integer>();
		indices.add(index);
	}
	
	public void apply(List<T> arr) {
		arr.add(list.get(indices.get(0)));
	}

	public List<Integer> getAffectedIndices() {
		return null;
	}

	public boolean isEmphasized() {
		return true;
	}
	

}
