package binarysearch.rotationpoint;

import java.util.Scanner;

public class RotationPoint {

    // Method to find the rotation point of a sorted array
    static int rotationIndex(int[] arr) {
        int start = 0;     // Start index
        int end = arr.length-1;     // end index

        int mid;             // to track the middle of the array

        while(start <= end) {
            mid = start+(end-start)/2;

            if(arr[mid] > arr[end]) {
                start = mid+1;
            }
            else if(arr[mid] < arr[end]) {
                end = mid;
            }
            else if(start == end) {
                return start;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        // Scanner object to take the input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the number of elements in the array
        System.out.println("Enter the size of the array: ");
        int  size = input.nextInt();

        // declare the array
        int[] arr = new int[size];

        // Prompt the user to enter the elements of array
        System.out.println("Enter the elements of array: ");
        for(int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
        }

        // Call the method to get the index from where the array is rotated
        System.out.println("The rotation index(smallest element index) of the array is: "+rotationIndex(arr));


        input.close();
    }

}