//Problem Statement: Sorting Large Data Efficiently
//Objective:
//Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
//Approach:
//Bubble Sort: Repeated swapping (inefficient for large data).
//Merge Sort: Divide & Conquer approach (stable).
//Quick Sort: Partition-based approach (fast but unstable).



package algorithmruntimeanalysis.sortinglargedataseteffeciently;

import java.util.Random;

public class SortingLargeDataSets {


    public static void main(String[] args) {
        // example data set
        int dataSetSize = 10_000;
        int[] dataSet = new int[dataSetSize];
        Random random = new Random();
        for (int i = 0; i < dataSetSize; i++) {
            dataSet[i] = random.nextInt();
        }
        int[] copyDataSet = dataSet.clone();
        // sorting the dataSet array by various methods to compare different sorting algorithm

        System.out.println("Bubble sort time taken :-");
        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(dataSet);
        long endTime = System.nanoTime();

        // printing the time taken by bubble sort to sort the data set
        System.out.println(Math.abs(startTime - endTime));

        // reverting the dataSet to unsorted version
        dataSet = copyDataSet.clone();

        System.out.println("Merge sort time taken :-");
        startTime = System.nanoTime();
        MergeSort.mergeSort(dataSet, 0, dataSetSize - 1);
        endTime = System.nanoTime();

        // printing the time taken by merge sort to sort the data set
        System.out.println(Math.abs(startTime - endTime));

        // reverting the dataSet to unsorted version
        dataSet = copyDataSet.clone();

        System.out.println("quick sort time taken :-");
        startTime = System.nanoTime();
        QuickSort.quickSort(dataSet, 0, dataSetSize - 1);
        endTime = System.nanoTime();

        // printing the time taken by merge sort to sort the data set
        System.out.println(Math.abs(startTime - endTime));

    }
}
