package solutions.grind75.week1;

public class ValidAnagram {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int last = s.length() - 1;

        while (start < last) {
            char currS = s.charAt(start);
            char currL = s.charAt(last);

            if (!(Character.isLetter(currS) || Character.isDigit(currS))) {
                start++;
            } else if (!(Character.isLetter(currL) || Character.isDigit(currL))) {
                last--;
            } else {
                if (currS != currL) {
                    return false;
                }

                start++;
                last--;
            }
        }

        return true;
    }
}
