package solutions.grind75.week6;

class StringToInteger
 {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0, n = s.length();
        int sign = 1;
        int result = 0;

        // Skip leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Handle sign if present
        if (index < n) {
            char signChar = s.charAt(index);
            if (signChar == '-' || signChar == '+') {
                sign = (signChar == '-') ? -1 : 1;
                index++;
            }
        }

        // Convert numeric characters to integer and handle overflow
        while (index < n) {
            char currentChar = s.charAt(index);
            if (!Character.isDigit(currentChar)) {
                break; // Stop at the first non-digit character
            }

            int digit = currentChar - '0';

            // Check for overflow before multiplying and adding
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}

