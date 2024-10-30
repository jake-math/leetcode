package solutions.grind75.week1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
        public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        Set<Character> left = new HashSet<>('(', '['. '{');
        Set<Character> right = new HashSet<>(')', ']', '}');

        for (Character c : s) {
            if (left.contains(c)) {
                brackets.add(c);
            } else {
                
            }
        }
        
        if (left.contains())

        return true;
    } 
}
