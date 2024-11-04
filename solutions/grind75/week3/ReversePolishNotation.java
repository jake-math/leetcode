package solutions.grind75.week3;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                int sol = 0;
                switch (token) {
                    case "+":
                        sol = n1 + n2;
                        break;
                    case "-":
                        sol = n1 - n2;
                        break;
                    case "/":
                        sol = n1 / n2;
                        break;
                    case "*":
                        sol = n1 * n2;
                        break;                                                                        
                }  

                stack.push(sol);
            }
        }

        return stack.pop();
    }

    public boolean isNumber(String toCheck) {
        try {
            Integer.parseInt(toCheck);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
