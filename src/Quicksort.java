/**
 * Created by petriccione on 9/22/15.
 */


/**
 *

 12 points: Once you get your partition and quicksort methods working correctly, create a recursive method called
 randomizedQuicksort as in the slides/textbook, which is extremely similar to quicksort above. Its parameters, return
 value, and purpose are the same as the above quicksort method.  The only difference is the choice of pivot.  First,
 swap a randomly selected element in the subarray with the rightmost element of the subarray, then proceed as above
 to use the rightmost element as the pivot, by invoking partition and recursing as normal for quicksort. You may use
 the the java.util.Random class as a random number generator.
 Do not use the Java Standard Library or other libraries, except you may use:

 console I/O
 java.util.Arrays.toString
 the java.util.Random class.
 You must implement your methods described above from scratch. Do not copy a solution from any person or third party
 source, but you may use the pseudocode in the textbook and the course webpage. Design and write the code yourself.

 Remember to comment your code! You should have a header comment with your name, date, class, assignment, and a brief
 description of what your code does. Read the syllabus carefully for details on all grading rubrics for coding homework.


 */
public class Quicksort {

    /**
     * 12 points: Implement a recursive method named quicksort. Implement quicksort as in the slides/textbook, using the
     rightmost element of the subarray as the pivot (the "naive" pivot choice). One parameter will be an array to sort.
     Two more parameters will be the start and end index of the subarray in which to sort. It is up to you whether the
     upper bound is inclusive or exclusive, but comment which you chose to do -- the pseudocode uses an inclusive upper
     bound. This method will have no return value, and its only effect will be to rearrange the given array values into
     sorted order.
     * QUICKSORT(A, p, r)
     if p < r  // base case is the implied empty else case
       q = PARTITION(A, p, r) // split 2 subproblems at q
       QUICKSORT(A, p, q - 1)
       QUICKSORT(A, q + 1, r)
     else--> you're done

     * @param arr The array to be sorted.
     * @param p  The pivot to sort the numbers around.
     * @param r  The right boundary of the subarray to be sorted.
     */
    public static void quicksort(int[] arr, int p, int r) {
        if (p < r) {
          int q = partition(arr, p,r);  //split into 2 subproblems at q
            quicksort(arr,p,q-1);
            quicksort(arr,q+1,r);
        }
    }

    public static String arrayPrinter(int[] array){
        System.out.print("\nThe array looks like: ");
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += "[" + array[i] + "]";
        }
        return result;
    }

    /**
     * 24 points: You will need to define a private (helper) method called partition as in the slides/textbook, which is
     invoked by quicksort. The parameters are the same as quicksort, but partition also returns an int index used by
     quicksort to divide the two recursive subproblems.

     x = A[r] // The value x is called the pivot value, chosen at index r
     i = p - 1
     for j = p to r - 1 // j is loop variable. Iterate through subarray.
     if A[j] <= x // we find a “small” value less than the pivot x
     i = i + 1
     swap A[i] with A[j] // The “small” element goes left
     swap A[i + 1] with A[r] // put pivot between left and right sides
     return i + 1 // This is the index q in QUICKSORT

     * @param args
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








    public static void main(String[] args) {
        /**
         * In the main method, invoke both quicksort and randomizedQuicksort that you've implemented at least five
         times each on different inputs, for testing purposes (these two methods are detailed below).  Alternatively,
         you may rig your main method to take an array from the user via the Scanner class, then display the output to
         the console, all wrapped up in a loop that continues until the user exits the program.  Write all the inputs
         and the results into the console. This is the testing portion of the assignment.
         */
        int[] myArr1 = {5,4,3,2,1,11,34,19};
        System.out.println(arrayPrinter(myArr1));
        quicksort(myArr1, 5, 7);
        System.out.println(arrayPrinter(myArr1));





    }


}
