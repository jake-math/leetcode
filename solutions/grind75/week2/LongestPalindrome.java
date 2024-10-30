package solutions.grind75.week2;

import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int sol = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                sol += 2;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            sol += 1;
        }

        return sol;
    }
}
