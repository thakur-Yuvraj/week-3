package binarysearch.firstlastoccurrence;

import java.util.Scanner;

public class FirstLastOccurrence {

    // Method to find the first occurrence of a target
    static int findFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        int mid; // To separate the array in left and right part

        int idx = -1;      // To store the index of the target element

        while(start <= end) {
            mid = start+(end-start)/2;

            if(arr[mid] == target) {
                end = mid-1;
                idx = mid;
            }
            else if(target > arr[mid]) {
                if(idx != -1) {
                    return idx;
                }
                start = mid+1;
            }
            else {
                if(idx != -1) {
                    return idx;
                }
                end = mid-1;
            }
        }
        return idx;
    }

    static int findLastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        int mid;

        int idx = -1;

        while(start <= end) {
            mid = start+(end-start)/2;

            if(arr[mid] == target) {
                start = mid+1;
                idx = mid;
            }
            else if(arr[mid] > target) {
                if(idx == -1) {
                    return idx;
                }
                end = mid-1;
            }
            else {
                if(idx != -1) {
                    return idx;
                }
                start = mid+1;
            }

        }

        return idx;
    }

    public static void main(String[] args) {

        // Create the object of scanner to take the input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the array size
        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        // Declare an array
        int[] arr = new int[size];

        // prompt the user to enter the array elements
        for(int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
        }

        // prompt the user to enter the target
        System.out.println("Enter the target value: ");
        int target = input.nextInt();

        // Call the method to get the first occurrence
        int firstOccurrence = findFirstOccurrence(arr, target);

        // Call the method to get the last occurrence
        int lastOccurrence = findLastOccurrence(arr, target);

        // Output
        System.out.println("The first occurrence of "+target+" is: "+firstOccurrence);
        System.out.println("The last occurrence of "+target+" is: "+lastOccurrence);

        input.close();
    }
}