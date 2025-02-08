package algorithmruntimeanalysis.sortinglargedataseteffeciently;

public class BubbleSort {
    // helper functon to swap two element
    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    // method to show bubble sort algorithm time complexity
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }
}
