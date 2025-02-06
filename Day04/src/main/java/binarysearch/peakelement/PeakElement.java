package binarysearch.peakelement;

import java.util.Scanner;

public class PeakElement {

    // Method to find the peak element
    static int findPeekElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int mid;


        while(start <= end) {
            mid = start + (end-start)/2;

            if((mid >0 && mid < arr.length-1) && (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])) {
                return arr[mid];
            }
            else if(mid == 0 && arr[mid] > arr[mid+1]) {
                return arr[mid];
            }
            else if(mid == arr.length-1 && arr[mid] > arr[mid-1]) {
                return arr[mid];
            }
            else if(arr[mid] > arr[mid-1]) {
                start = mid+1;
            }
            else if(arr[mid] < arr[mid-1]) {
                end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {

        // Scanner object to take the input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the size of the string
        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        // declare the array
        int[] arr = new int[size];

        // Prompt the user to enter the elements of array
        System.out.println("Enter the elements in array: ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
        }

        // Call the method to get the peek element
        int peekElement = findPeekElement(arr);

        // Output
        if(peekElement == -1) {
            System.out.println("there is no peek element in this array: ");
        }
        else {
            System.out.println("The peek element is: "+peekElement);
        }

        // Close the scanner object
        input.close();
    }
}