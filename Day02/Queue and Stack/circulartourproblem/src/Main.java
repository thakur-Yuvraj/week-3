//Circular Tour Problem
//Problem: Given a set of petrol pumps with petrol and distance to the next pump, determine the starting point for completing a circular tour.
//Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.

public class Main {

    public static void main(String[] args) {
        // example petrol and distance
        int[] gas = {1,2,3,4,5};
        int[] distance = {3,4,5,1,2};

        // calculating if it is possible to do circular tour and return the start location
        int startingPos = CircularTourSolution.canCompleteCircuit(gas, distance);

        // printing the answer
        if (startingPos == -1) {
            System.out.println("There is no starting point to complete a circular tour");
        }else {
            System.out.println("The starting poinnt of the tour will be : "+ startingPos);
        }
    }
}