package solutions.grind75.week3;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> solution = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                solution.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                solution.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        solution.add(newInterval);

        return solution.toArray(new int[solution.size()][]);
    }
}
