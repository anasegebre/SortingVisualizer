package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;

public interface SortEvent<T> {
    void apply(ArrayList<T> arr);

    ArrayList<Integer> getAffectedIndices();

    boolean isEmphasized();
}
