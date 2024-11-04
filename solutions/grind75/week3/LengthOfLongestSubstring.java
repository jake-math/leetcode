package solutions.grind75.week3;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int maxLength = -1;
        Set<Character> seenChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            seenChars.clear();
            int currLength = 0;
            
            for (int j = i; j < s.length(); j++) {
                char currChar = s.charAt(j);
                                
                if (seenChars.contains(currChar)) {
                    j = s.length();
                } else {
                    seenChars.add(currChar);
                    currLength++;
                }
            }
            
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
    }
}