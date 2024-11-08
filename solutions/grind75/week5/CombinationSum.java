package solutions.grind75.week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> sol = new HashSet<>();
        combination(sol, new ArrayList<>(), candidates, target, 0);
        return sol.stream().toList();
    }

    private void combination(Set<List<Integer>> sol, List<Integer> curr, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            sol.add(new ArrayList<>(curr));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {                
                curr.add(candidates[i]);
                combination(sol, curr, candidates, remain - candidates[i], i);
                curr.remove(curr.size() - 1);
            }        
        }
    }
}
