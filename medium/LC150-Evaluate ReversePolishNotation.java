/**
use stack 
push the operands into the stack]
when you encounter a operator pop the operands and compute the result
push the result back into stack
**/
class Solution {
    public int evalRPN(String[] tokens) {

        if (tokens.length == 1) return Integer.valueOf(tokens[0]);

        Stack<Integer> stack = new Stack<>();

        int res=0;
        
        for (String str: tokens) {
            if (!isOperator(str)) {
                stack.push(Integer.valueOf(str));
            } else {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                res = calculate (str.charAt(0), leftOperand,rightOperand);
                stack.push(res);
            }
        }
        
        return res;
    }

    boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") ||str.equals("*") ||str.equals("/") ;
    }

    int calculate(char op, int leftOperand, int rightOperand) {

        switch (op) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                return leftOperand / rightOperand;
        }
        return -1;
    }
}
