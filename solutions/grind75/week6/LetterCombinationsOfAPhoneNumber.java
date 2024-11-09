package solutions.grind75.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> sol = new ArrayList<>();

        Map<Integer, char[]> intToChar = Map.of(
            2, new char[]{'a', 'b', 'c'},
            3, new char[]{'d', 'e', 'f'},
            4, new char[]{'g', 'h', 'i'},
            5, new char[]{'j', 'k', 'l'},
            6, new char[]{'m', 'n', 'o'},
            7, new char[]{'p', 'q', 'r', 's'},
            8, new char[]{'t', 'u', 'v'},
            9, new char[]{'w', 'x', 'y', 'z'}
        );

        comb(sol, "", digits, 0, intToChar);
        return sol;
    }

    public void comb(List<String> sol, String curr, String digits, int idx, Map<Integer, char[]> intToChar) {
        if (idx == digits.length()) {
            sol.add(curr);
            return;
        }

        int currInt = digits.charAt(idx) - '0';
        char[] currChars = intToChar.get(currInt);
        
        for (char c : currChars) {
            comb(sol, curr + c, digits, idx + 1, intToChar);
        }
    }
}
