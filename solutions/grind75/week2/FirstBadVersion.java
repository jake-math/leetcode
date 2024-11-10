package solutions.grind75.week2;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;

        while (first < last) {
            int mid = first + (last - first) / 2;

            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        return first;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
