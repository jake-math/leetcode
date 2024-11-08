package solutions.grind75.week5;

class SortColors {
    public void sortColors(int[] nums) { 
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // if 0 move to the bottom
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // if 1 keep in place
                mid++;
            } else {
                // if 2 move to the top
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
