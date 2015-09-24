/**
 * CSCI 333 Fall 2015, Professor Whitley
 * Homework 4: Quicksort
 * Created by Andrew Petriccione on 9/22/15.
 * The goal of this homework is to create a class with a method using the quicksort algorithm to sort an array.
 * To get quicksort to work we need another method called 'partition' which will return an index for the
 * quicksort method to split the array into two sub-arrays, which quicksort can then overcome by calling itself
 * recursively. After getting the quicksort method to work, we need to create another method very similar to
 * quicksort called 'randomizedQuicksort' that uses a randomly selected index from the sub-array as the pivot.
 */
import java.util.Arrays;
import java.util.Random;
/**
 * Quicksort is a class that has methods to sort the integers in an array using the quicksort algorithm.
 */
public class Quicksort {
    /**
     * quicksort is a recursive method to sort integers in an array.
     * @param arr The array to be sorted.
     * @param p  The starting point (lower bounds) index of the sub-array to sort.
     * @param r  The ending point (inclusive upper bounds) index of the array to be sorted.
     */
    public static void quicksort(int[] arr, int p, int r) {
        if (p < r) {
          int q = partition(arr, p,r);
            quicksort(arr,p,q-1);
            quicksort(arr,q+1,r);
        }
    }
    /**
     * arrayPrinter is a helper method to print the contents of an array of ints.
     * @param arr The array to be printed.
     * @return a String that can be printed with System.out.print
     */
    public static String arrayPrinter(int[] arr){
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += "[" + arr[i] + "]";
        }
        return result;
    }
    /**
     * partition is a helper method for the sorting methods quicksort and randomizedQuicksort which functions
     * to partition an array into smaller sub-arrays that can be sorted recursively.
     * @param arr The array to partition.
     * @param p   The starting point (lower bounds) index of the sub-array to partition.
     * @param r   The ending point (upper bounds) index of the sub-array to partition.
     * @return the index to be passed to the calling method
     *
     */
    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p;j < r;j++) {
            if (arr[j] <= x) {
                i++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        int swap2 = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = swap2;
        return i + 1;
    }
    /**
     * randomizedQuicksort uses the quicksort algorithm with a randomly chosen pivot to sort an array of numbers.
     * @param arr The array to to perform randomizedQuicksort on.
     * @param p  The starting point (lower bounds) index of the sub-array to sort.
     * @param r  The ending point (upper bounds) index of the sub-array to sort.
     */
    public static void randomizedQuicksort(int[] arr, int p, int r) {
        if (p < r) {
            //int z = random b/t p & r
            Random myRand = new Random();
            int z = myRand.nextInt(r - p + 1) + p;
           // System.out.println("r is: " + r + " & p is: " + p + " & z is: " + z);
            int swap = arr[z];
            arr[z] = arr[r] ;
            arr[r] = swap;
            int q = partition(arr, p, r);
            randomizedQuicksort(arr, p, q - 1);
            randomizedQuicksort(arr, q + 1, r);
        }
    }
    public static void main(String[] args) {
        /**
         * In the main method, invoke both quicksort and randomizedQuicksort that you've implemented at least five
         times each on different inputs, for testing purposes (these two methods are detailed below).  Alternatively,
         you may rig your main method to take an array from the user via the Scanner class, then display the output to
         the console, all wrapped up in a loop that continues until the user exits the program.  Write all the inputs
         and the results into the console. This is the testing portion of the assignment.
         */
        int[] myArr1 = {5,4,3,2,1,11,34,19};
        System.out.println("The array myArr1 starts like this: \n" + arrayPrinter(myArr1) + "\n");
        int[] myArr1Copy = Arrays.copyOf(myArr1,myArr1.length);
        System.out.println("The copy myArr1Copy looks like this: \n" +arrayPrinter(myArr1Copy) +"\n");
        quicksort(myArr1, 0, myArr1.length - 1);
        System.out.println("After quicksort myArr1 looks like this: \n" + arrayPrinter(myArr1) + "\n");
        randomizedQuicksort(myArr1Copy, 0, myArr1Copy.length - 1);
        System.out.println("After randomizedQuicksort myArr1Copy looks like this: \n" + arrayPrinter(myArr1Copy) + "\n");

        int[] myArr2 = {5,4,3,2,1,0,11};
        int[] myArr2Copy = Arrays.copyOf(myArr2,myArr2.length);
        System.out.println("The array myArr2 starts like this: \n" + arrayPrinter(myArr2) + "\n");
        System.out.println("The copy myArr2Copy looks like this: \n" + arrayPrinter(myArr2Copy) + "\n");
        quicksort(myArr2, 0, myArr2.length - 1);
        System.out.println("After quicksort myArr2 looks like this: \n" + arrayPrinter(myArr2) + "\n");
        randomizedQuicksort(myArr2Copy, 0, myArr2Copy.length - 1);
        System.out.println("After randomizedQuicksort myArr2Copy looks like this: \n" + arrayPrinter(myArr2Copy) + "\n");

        int[] myArr3 = {15,14,33,12,111,-30,110};
        int[] myArr3Copy = Arrays.copyOf(myArr3,myArr3.length);
        System.out.println("The array myArr3 starts like this: \n" + arrayPrinter(myArr3) + "\n");
        System.out.println("The copy myArr3Copy looks like this: \n" + arrayPrinter(myArr3Copy) + "\n");
        quicksort(myArr3, 0, myArr3.length - 1);
        System.out.println("After quicksort myArr2 looks like this: \n" + arrayPrinter(myArr3) + "\n");
        randomizedQuicksort(myArr3Copy, 0, myArr3Copy.length - 1);
        System.out.println("After randomizedQuicksort myArr2Copy looks like this: \n" + arrayPrinter(myArr3Copy) + "\n");

        int[] myArr4 = {2,44,313,92,11,90,1};
        int[] myArr4Copy = Arrays.copyOf(myArr4,myArr4.length);
        System.out.println("The array myArr4 starts like this: \n" + arrayPrinter(myArr4) + "\n");
        System.out.println("The copy myArr4Copy looks like this: \n" + arrayPrinter(myArr4Copy) + "\n");
        quicksort(myArr4, 0, myArr4.length - 1);
        System.out.println("After quicksort myArr4 looks like this: \n" + arrayPrinter(myArr4) + "\n");
        randomizedQuicksort(myArr4Copy, 0, myArr4Copy.length - 1);
        System.out.println("After randomizedQuicksort myArr4Copy looks like this: \n" + arrayPrinter(myArr4Copy) + "\n");

        int[] myArr5 = {88,77,13,21,99,4};
        int[] myArr5Copy = Arrays.copyOf(myArr5,myArr5.length);
        System.out.println("The array myArr5 starts like this: \n" + arrayPrinter(myArr5) + "\n");
        System.out.println("The copy myArr5Copy looks like this: \n" + arrayPrinter(myArr5Copy) + "\n");
        quicksort(myArr5, 0, myArr5.length - 1);
        System.out.println("After quicksort myArr5 looks like this: \n" + arrayPrinter(myArr5) + "\n");
        randomizedQuicksort(myArr5Copy, 0, myArr5Copy.length - 1);
        System.out.println("After randomizedQuicksort myArr5Copy looks like this: \n" + arrayPrinter(myArr5Copy) + "\n");





    }


}
