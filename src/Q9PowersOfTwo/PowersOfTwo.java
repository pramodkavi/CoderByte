package Q9PowersOfTwo;

import java.util.Scanner;

public class PowersOfTwo {
    boolean PowersofTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0; // Ensure num is positive
    }

    public static void main (String[] args) {
        // keep this function call here
//        Scanner s = new Scanner(System.in);
        PowersOfTwo c = new PowersOfTwo();
        System.out.print(c.PowersofTwo(22));
    }
}