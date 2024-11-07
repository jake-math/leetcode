package solutions.grind75.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SearchRotatedArray {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        } 

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        merged.add(prev);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] >= curr[0] && prev[1] <= curr[1]) {
                merged.remove(prev);
                int[] newMerged = new int[]{prev[0], curr[1]};
                merged.add(newMerged);
                prev = newMerged;
            } if (prev[1] >= curr[0] && prev[1] >= curr[1]) {
                merged.remove(prev);
                int[] newMerged = new int[]{prev[0], prev[1]};
                merged.add(newMerged);
                prev = newMerged;
            } else {
                merged.add(curr);
                prev = curr;
            }
        }

		return merged.toArray(new int[merged.size()][]);

    }
}
