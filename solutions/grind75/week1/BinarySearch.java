package solutions.grind75.week1;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int idx = len / 2;
        int count = 0;
        while (idx >= 0 && idx < len && count <= len) {
            int curr = nums[idx];
            if (curr == target) {
                return idx;
            }

            if (curr < target) {
                idx++;
            } else {
                idx--;
            }

            count++;
        }

        return -1;
    }
}
