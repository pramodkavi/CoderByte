package Q11_OtherProducts;

// For this challenge you will return the product of a set of elements in an array.  have the function OtherProducts(arr)
// take the array of numbers stored in arr and return a new list of the products of all the other numbers in the array for
// each element. For example: if arr is [1, 2, 3, 4, 5] then the new array, where each location in the new array is
// the product of all other elements, is [120, 60, 40, 30, 24]. The following calculations were performed to get this
// answer: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]. You should generate this new array and then return
// the numbers as a string joined by a hyphen: 120-60-40-30-24. The array will contain at most 10 elements and at
// least 1 element of only positive integers.

public class OtherProducts {
    public static String otherProducts(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Calculate total product of all elements
        int totalProduct = 1;
        for (int num : arr) {
            totalProduct *= num;
        }

        // Calculate result array by dividing totalProduct by each element
        for (int i = 0; i < n; i++) {
            result[i] = totalProduct / arr[i];
        }

        // Convert result array to hyphen-separated string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(result[i]);
            if (i < n - 1) {
                output.append("-");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(otherProducts(arr)); // Output: 120-60-40-30-24
    }
}

//Explanation:
//        Compute the Total Product
//          Iterate through the array and compute the product of all elements.
//        Compute Each Element's Product
//          For each element arr[i], calculate totalProduct / arr[i] to get the product of all other numbers.
//          Convert the Result to a Hyphen-Separated String
//
//        Use a StringBuilder to construct the output efficiently