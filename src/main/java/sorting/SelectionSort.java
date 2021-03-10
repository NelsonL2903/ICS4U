package sorting;

import java.util.Random;

public class SelectionSort {

public static void main(String[] args) {
SelectionSort selectionSort = new SelectionSort();
int[] array = new int[20];
selectionSort.initialize(array);
selectionSort.print(array);
selectionSort.sort(array);
selectionSort.print(array);
}
private void initialize(int[] array) {
	// create an array of random integers
	Random ran = new Random();
	// for each value of the array, assigns a random number between 0 and 100
	for (int i = 0; i < array.length; ++i) {
		array[i] = (ran.nextInt(101));
	}
}
private void swap(int[] array, int a, int b) {
	// swap array[a] and array[b]
	int store = array[a];
	array[a] = array[b];
	array[b] = store;
}
private void print(int[] array) {
	// print the array
	for (int i = 0; i < array.length; ++i) {
		System.out.print(array[i] + " ");
	}
	System.out.println("");
}
private void sort(int[] array) {
	// you'll need a nested loop to implement selection sort
	for (int i = 0; i < array.length-1; ++i) {
		int minidx = i;
		for (int j = i + 1; j < array.length; ++j) {
			// 
			if (array[j] < array[minidx]) {
			minidx = j;
			}
		}
		swap(array, i, minidx);
	}
}

}
