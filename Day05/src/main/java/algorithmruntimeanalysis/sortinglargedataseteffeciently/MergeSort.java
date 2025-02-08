package algorithmruntimeanalysis.sortinglargedataseteffeciently;

public class MergeSort {
    // method to show merge sort algorithm time complexity
    public static void mergeSort(int[] arr, int st, int ed) {
        if (ed >= st) return;
        int mid = st + (ed - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, ed);
        merge(arr, st, ed, mid);
    }

    // helper functon for mergeSort to merge two sorted arrays
    public static void merge(int[] arr, int st, int ed, int mid) {
        int[] temp = new int[ed - st + 1];

        // for temp array iteration
        int tdx = 0;

        // for first sorted array iteration
        int idx = st;

        // for second sorted array iteration
        int jdx = mid + 1;

        while (idx <= mid && jdx <= ed) {
            if (arr[idx] < arr[jdx]) {
                temp[tdx++] = arr[idx++];
            }
            else {
                temp[tdx++] = arr[jdx++];
            }
        }

        while (idx <= mid) {
            temp[tdx++] = arr[idx++];
        }

        while (jdx <= ed) {
            temp[tdx++] = arr[jdx++];
        }

        idx = st;
        for (int j : temp) {
            arr[idx++] = j;
        }

    }
}
