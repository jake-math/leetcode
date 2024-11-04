package solutions.grind75.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array
        List<List<Integer>> sol = new ArrayList<>();
        Set<String> seen = new HashSet<>();  
        int len = nums.length;
        
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int currVal = nums[i] + nums[j] + nums[k];
                if (currVal == 0) {
                    String tripletString = nums[i] + " " + nums[j] + " " + nums[k];
                    seen.add(tripletString);
                    j++;
                } else if (currVal < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        System.out.println(seen);

        while (!seen.isEmpty()) {
            String curr = seen.iterator().next();
            ArrayList<Integer> valid = new ArrayList<>();
            String[] validAsStrings = curr.split(" ");

            for (String s : validAsStrings) {
                valid.add(Integer.parseInt(s));
            }

            sol.add(valid);
            seen.remove(curr);
        }

        return sol;
    }
}

// Time complexity of O(n^2) due to the nested loop

