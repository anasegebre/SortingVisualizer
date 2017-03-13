package edu.grinnell.sortingvisualizer.sortevents;
import java.util.List;
import java.util.ArrayList;

public class SwapEvent<T> implements SortEvent<T> {
	
	public List<Integer> indices;
	
	public SwapEvent(int n, int k) {
		indices = new ArrayList<Integer>();
		indices.add(n);
		indices.add(k);
	}
	
	public void apply(ArrayList<T> arr) {
		T temp = arr.get(indices.get(0));
		arr.set(indices.get(0), arr.get(indices.get(1)));
		arr.set(indices.get(1), temp);
	}
	
	public List<Integer> getAffectedIndices() {
		return indices;
	}
	
	public boolean isEmphasized() {
		return true;
	}

}
