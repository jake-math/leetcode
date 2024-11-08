package solutions.grind75.week6;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        backtrack(sol, new ArrayList<>(), nums, 0);
        return sol;
    }

    private void backtrack(List<List<Integer>> sol, ArrayList<Integer> curr, int[] nums, int start) {
        sol.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(sol, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
