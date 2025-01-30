package Q3_Consecutive;

import java.util.Arrays;
import java.util.Scanner;

public class Consecutive {
    int Consecutive(int[] arr) {
        Arrays.sort(arr);

        int amount = 0;
        for (int i = 1; i < arr.length; i++) {
            amount += Math.abs(arr[i] - arr[i - 1]) - 1;
        }

        return amount;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        Consecutive c = new Consecutive();
        System.out.print(c.Consecutive(new int[] {-2,10,4}));
    }
}
