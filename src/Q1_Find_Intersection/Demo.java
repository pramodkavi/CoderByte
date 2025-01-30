package Q1_Find_Intersection;

import java.util.Arrays;

public class Demo {
    public static String findIntersection(String[] strArr) {
        String[] arr1 = strArr[0].split(", ");
//        System.out.println("arr1 "+ Arrays.toString(arr1));
        System.out.println("arr1 "+ arr1[1]);
        String[] arr2 = strArr[1].split(", ");
//        System.out.println("arr2 "+Arrays.toString(arr2));

        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[j]);

            if (num1 == num2) {
                if (result.length() > 0) {
                    result.append(",");
                }
                result.append(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }

        return result.length() > 0 ? result.toString() : "false";
    }

    public static void main(String[] args) {
        String[] input = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(findIntersection(input)); // Output: 1,4,13
    }
}
