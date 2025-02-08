//Problem Statement: Search a Target in a Large Dataset
//Objective:
//Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
//Approach:
//Linear Search: Scan each element until the target is found.
//Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
//Comparative Analysis:
//Dataset Size (N)
//Linear Search (O(N))
//Binary Search (O(log N))
//Expected Result:
//Binary Search performs much better for large datasets, provided data is sorted.



package algorithmruntimeanalysis.linearsearchbinarysearchinlargedataset;


public class LinearBinarySearchTimeComplexityComparison {

    // method to demonstrate linear search in dataset
    public static boolean linearSearch(int[] dataSet, int target) {
        for (int i : dataSet) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    // method to demonstrate binary search in dataset
    public static boolean binarySearch(int[] dataSet, int target) {
        int st = 0;
        int ed = dataSet.length - 1;

        while(st <= ed) {

            int mid = st + (ed - st) / 2;

            if (dataSet[mid] == target) {
                return true;
            }
            else if (dataSet[mid] > target) {
                ed = mid - 1;
            }
            else {
                st = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // example data set
        int dataSetSize = 10_00_000;
        int[] dataSet = new int[dataSetSize];
        for (int i = 0; i < dataSetSize; i++) {
            dataSet[i] = i;
        }

        // performing linear search in dataset
        int target = 96538;
        long startTime = System.nanoTime();
        System.out.println(linearSearch(dataSet, target));
        long endTime = System.nanoTime();

        // printing the time taken by linear search
        System.out.println(Math.abs(startTime - endTime));

        // performing binary search in dataset
        startTime = System.nanoTime();
        System.out.println(binarySearch(dataSet, target));
        endTime = System.nanoTime();

        // printing the time taken by binary search
        System.out.println(Math.abs(startTime - endTime));
    }

}
