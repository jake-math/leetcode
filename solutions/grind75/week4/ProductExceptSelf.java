package solutions.grind75.week4;

import java.util.Arrays;

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }

            ans[i] *= left;
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                right = right * nums[i + 1];
            }

            ans[i] *= right;
        }

        return ans;
    }
}
