package edu.grinnell.sortingvisualizer.sortevents;
import java.util.List;
import java.util.ArrayList;

public interface SortEvent<T> {
    void apply(ArrayList<T> arr);
    
    List<Integer> getAffectedIndices();
    
    boolean isEmphasized();
}
