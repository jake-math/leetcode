package solutions.grind75.week6;

class LongestSubstring {
    public String longestPalindrome(String s) {
        String sol = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > sol.length()) {
                sol = odd;
            }

            if (even.length() > sol.length()) {
                sol = even;
            }
        }

        return sol;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
