package Q12_MovingMedian;
import java.util.*;

public class MovingMedian {

    public static String movingMedian(int[] arr) {
        int windowSize = arr[0]; // The first element is the window size
        List<Integer> window = new ArrayList<>(); // List to store the window elements
        StringBuilder result = new StringBuilder();

        // Iterate through the array (excluding the first element, which is the window size)
        for (int i = 1; i < arr.length; i++) {
            window.add(arr[i]); // Add new element to the window

            // If window size exceeds the limit, remove the oldest element
            if (window.size() > windowSize) {
                window.remove(0);
            }

            // Sort the window to find the median
            List<Integer> sortedWindow = new ArrayList<>(window);
            Collections.sort(sortedWindow);

            // Find the median
            int median;
            int size = sortedWindow.size();
            if (size % 2 == 1) {
                // Odd number of elements, take middle element
                median = sortedWindow.get(size / 2);
            } else {
                // Even number of elements, take average of two middle elements
                median = (sortedWindow.get(size / 2 - 1) + sortedWindow.get(size / 2)) / 2;
            }

            // Append median to result
            if (i > 1) {
                result.append(","); // Add comma separator
            }
            result.append(median);
        }

        return result.toString(); // Return final result as comma-separated string
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 5, 10, 6, 4, 3, 1};
        System.out.println(movingMedian(arr)); // Output: "1,2,3,5,6,6,4,3"
    }
}

// Explanation of the Code
//    Extract the Window Size (N)
//          The first element of arr is N, which represents the sliding window size.
//    Iterate Over the Remaining Elements
//        We add each new element to the window list.
//        If the window size exceeds N, remove the oldest element.
//
//    Sort the Window to Find the Median
//        Use Collections.sort() to sort the current window.
//
//    Compute the Median
//        If the window has an odd number of elements, pick the middle one.
//        If the window has an even number of elements, take the average of the two middle elements.
//
//    Build the Output String
//        Append each computed median to StringBuilder, separated by commas.
