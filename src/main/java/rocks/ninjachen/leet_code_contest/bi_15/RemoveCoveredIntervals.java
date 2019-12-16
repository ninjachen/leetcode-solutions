package rocks.ninjachen.leet_code_contest.bi_15;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        // wrong answer, the interval 2 part may be covered by other interval
        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // int[] map = new int[(int) Math.pow(10, 5)];
        int count = 1;
        int[] preInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] <= preInterval[1]) {
                // covered
            } else {
                preInterval = interval;
                count++;
            }
        }
        return count;
    }
}
