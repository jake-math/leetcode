package solutions.grind75.week2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            } else {
                seen.add(n);
            }
        }

        return false;
    }
}
