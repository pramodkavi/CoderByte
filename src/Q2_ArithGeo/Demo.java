package Q2_ArithGeo;

public class Demo {

    public static String arithGeo(int[] arr) {
        if (arr.length < 2) return "-1";

        boolean isArithmetic = true;
        boolean isGeometric = true;

        int diff = arr[1] - arr[0];
        double ratio = (double) arr[1] / arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                isArithmetic = false;
            }
            double secondRatio = (double) arr[i + 1] / arr[i];
            if (secondRatio!= ratio) {
                isGeometric = false;
            }
        }

        if (isArithmetic) return "Arithmetic";
        if (isGeometric) return "Geometric";
        return "-1";
    }

    public static void main(String[] args) {
        int[] input1 = {2, 4, 6, 8};
        int[] input2 = {2, 6, 18, 54};
        int[] input3 = {2, 5, 14, 30};

        System.out.println(arithGeo(input1)); // Output: Arithmetic
        System.out.println(arithGeo(input2)); // Output: Geometric
        System.out.println(arithGeo(input3)); // Output: -1
    }
}
