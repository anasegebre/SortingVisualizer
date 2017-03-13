package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {

	public List<Integer> indices;
	
	public CompareEvent(int n, int k) {
		indices = new ArrayList<Integer>();
		indices.add(n);
		indices.add(k);
	}
	
	public void apply(ArrayList<T> arr) {
		return;
	}

	public List<Integer> getAffectedIndices() {
		return this.indices;
	}

	public boolean isEmphasized() {
		return false;
	}

}
