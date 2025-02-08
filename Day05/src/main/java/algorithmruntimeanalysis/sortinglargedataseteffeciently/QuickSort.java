package algorithmruntimeanalysis.sortinglargedataseteffeciently;

public class QuickSort {
    // helper functon to swap two element
    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }



    // method to show quick sort algorithm time complexity
    public static void quickSort(int[] arr, int st, int ed) {
        if (ed >= st) {
            return;
        }
        int pivotIdx = partition(arr, st, ed);
    }

    // helper function for quick sort to find the partition
    private static int partition(int[] arr, int st, int ed) {
        int i = st - 1;
        for (int j = st; i < ed; j++) {
            if (arr[j] > arr[ed]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, ed);
        return i;
    }
}
