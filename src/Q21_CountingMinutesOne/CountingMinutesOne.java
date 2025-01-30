package Q21_CountingMinutesOne;

import java.util.Scanner;

public class CountingMinutesOne {
    final int MINUTES_IN_HOUR = 60;
    final int MINUTES_IN_DAY = 24 * 60;

    int CountingMinutesI(String str) {
        String[] times = str.split("-");

        int startTime = getMinuteOfDay(times[0]);
        int endTime = getMinuteOfDay(times[1]);

        return getDiff(startTime, endTime);

    }

    int getMinuteOfDay(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1].substring(0, parts[1].length() - 2));
        int minOfDay = time.toLowerCase().contains("pm") ? (hour * MINUTES_IN_HOUR) + min + (MINUTES_IN_DAY / 2) : (hour * MINUTES_IN_HOUR) + min;
        return minOfDay > MINUTES_IN_DAY ? minOfDay - MINUTES_IN_DAY : minOfDay;
    }

    int getDiff(int startTime, int endTime) {
        if (startTime <= endTime) return endTime - startTime;
        return (MINUTES_IN_DAY - startTime) + endTime;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        CountingMinutesOne c = new CountingMinutesOne();
        System.out.print(c.CountingMinutesI(s.nextLine()));
    }
}
