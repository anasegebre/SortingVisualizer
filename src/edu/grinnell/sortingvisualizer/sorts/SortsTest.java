package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SortsTest {

    @Test
    public void selectionSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.selectionSort(descendUnsrt);
        Sorts.selectionSort(ascendSrt);
        Sorts.selectionSort(oneUnsrt);
        Sorts.selectionSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }

    @Test
    public void insertionSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.insertionSort(descendUnsrt);
        Sorts.insertionSort(ascendSrt);
        Sorts.insertionSort(oneUnsrt);
        Sorts.insertionSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }
    
    @Test
    public void mergeSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.mergeSort(descendUnsrt);
        Sorts.mergeSort(ascendSrt);
        Sorts.mergeSort(oneUnsrt);
        Sorts.mergeSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }
 

    @Test
    public void quickSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.quickSort(descendUnsrt);
        Sorts.quickSort(ascendSrt);
        Sorts.quickSort(oneUnsrt);
        Sorts.quickSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }

   
    @Test
    public void bubbleSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.bubbleSort(descendUnsrt);
        Sorts.bubbleSort(ascendSrt);
        Sorts.bubbleSort(oneUnsrt);
        Sorts.bubbleSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }
    
    @Test
    public void shellSortTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);

        ArrayList<Integer> ascendUnsrt = new ArrayList<>();
        ascendUnsrt.add(4);
        ascendUnsrt.add(5);
        ascendUnsrt.add(70);
        ascendUnsrt.add(80);
        ascendUnsrt.add(100);

        ArrayList<Integer> ascendSrt = new ArrayList<>();
        ascendSrt.add(4);
        ascendSrt.add(5);
        ascendSrt.add(70);
        ascendSrt.add(80);
        ascendSrt.add(100);

        ArrayList<Integer> oneUnsrt = new ArrayList<>();
        oneUnsrt.add(4);

        ArrayList<Integer> oneSrt = new ArrayList<>();
        oneSrt.add(4);

        ArrayList<Integer> emptyUnsrt = new ArrayList<>();

        ArrayList<Integer> emptySrt = new ArrayList<>();

        Sorts.shellSort(descendUnsrt);
        Sorts.shellSort(ascendSrt);
        Sorts.shellSort(oneUnsrt);
        Sorts.shellSort(emptyUnsrt);

        assertEquals(descendUnsrt, descendSrt);
        assertEquals(ascendUnsrt, ascendSrt);
        assertEquals(oneUnsrt, oneSrt);
        assertEquals(emptyUnsrt, emptySrt);
    }
    
    @Test
    public void selectionEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.selectionSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);

    }
    
    @Test
    public void insertionEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.insertionSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);
    }
    
    @Test
    public void mergeEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.mergeSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);
    }
    
    @Test
    public void quickEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.quickSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);
    }
    
    @Test
    public void bubbleEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.bubbleSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);
    }
    
    @Test
    public void shellEventTest() {
        ArrayList<Integer> descendUnsrt = new ArrayList<>();
        descendUnsrt.add(100);
        descendUnsrt.add(80);
        descendUnsrt.add(70);
        descendUnsrt.add(5);
        descendUnsrt.add(4);
        ArrayList<Integer> descendUnsrt1 = (ArrayList<Integer>) descendUnsrt.clone();

        ArrayList<Integer> descendSrt = new ArrayList<>();
        descendSrt.add(4);
        descendSrt.add(5);
        descendSrt.add(70);
        descendSrt.add(80);
        descendSrt.add(100);
        
        Sorts.eventSort(descendUnsrt1, Sorts.bubbleSort(descendUnsrt));
        
        assertEquals(descendUnsrt1, descendSrt);
    }
    
    
    
}
