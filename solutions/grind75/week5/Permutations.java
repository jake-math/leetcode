package solutions.grind75.week5;

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        backtrack(sol, new ArrayList<>(), nums);
        return sol;
    }

    public void backtrack(List<List<Integer>> sol, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            sol.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!curr.contains(nums[i])) {
                    curr.add(nums[i]);
                    backtrack(sol, curr, nums);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
