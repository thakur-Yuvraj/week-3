package binarysearch.twodimensionalmatrix;

import java.util.Scanner;

public class BinarySearchInTwoDMatrix {

    // Method to find the indices of a given target value
    static boolean findTarget(int[][] arr, int target) {

        int start = 0;
        int end = arr[0].length-1;

        // this function call will give the row in which the target element is present
        int row = findTargetsRow(arr, target);

        // if we do not get the target row
        if(row == -1) {
            return false;
        }

        while(start <= end) {
            int mid = start+(end-start)/2;

            if(arr[row][mid] == target) {
                return true;
            }
            else if(arr[row][mid] < target) {
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return false;   // if the target element is not found it will return false
    }

    // Method to get the row of the target element
    static int findTargetsRow(int[][] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int columns = arr[0].length; // number of columns in the array
        int mid;

        while(start <= end) {
            mid = start+(end-start)/2;

            // Check for the target value row
            if((mid >0) && (target > arr[mid-1][columns-1] && target <= arr[mid][columns-1])) {
                return mid;    // return the row in which the target is present
            }
            else if(mid == 0 && target <= arr[mid][columns-1]) {
                return mid;
            }
            else if(target > arr[mid][columns-1]) {
                start = mid+1;
            }
            else if(target < arr[mid][0]) {
                end = mid-1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        // Scanner object to take the input
        Scanner input = new Scanner(System.in);

        // Prompt the user for the input
        System.out.println("Enter the number of rows in the matrix: ");
        int rows = input.nextInt();

        System.out.println("Enter the number of columns in the matrix: ");
        int columns = input.nextInt();

        // Declare the array
        int[][] arr = new int[rows][columns];

        for(int i=0; i<rows; i++) {
            System.out.println("Enter the elements of row: "+i);
            for(int j=0; j<columns; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        // Prompt the user to get the target value in the matrix
        System.out.println("Enter the target value that you  need to search: ");
        int target = input.nextInt();

        // Call the method to get result
        boolean result = findTarget(arr, target);

        // Output
        System.out.println("The target is in the matrix: "+result);
    }
}