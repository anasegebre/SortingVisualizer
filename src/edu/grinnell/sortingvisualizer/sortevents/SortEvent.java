package edu.grinnell.sortingvisualizer.sortevents;
import java.util.List;


public interface SortEvent<T> {
    void apply(List<T> arr);
    
    List<Integer> getAffectedIndices();
    
    boolean isEmphasized();
}
