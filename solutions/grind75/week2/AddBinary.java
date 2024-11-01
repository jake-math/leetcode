package solutions.grind75.week2;

class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        boolean carry = false;
        int index = 0;
        StringBuilder sol = new StringBuilder();

        while (index < aLen || index < bLen || carry) {
            int currA = index < aLen ? a.charAt(index) - '0' : 0;
            int currB = index < bLen ? b.charAt(index) - '0' : 0;
            
            int currSum = currA + currB + (carry ? 1 : 0);

            sol.append(currSum % 2);
            carry = currSum / 2 > 0;

            index++;
        }

        return new StringBuilder(sol).reverse().toString();
    }
}
