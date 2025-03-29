class Solution {
    public int calculate(String s) {

        int result = 0;
        int number = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch -'0');
                //result += number;
            }
            else if (ch == '+') {
                result += number * sign;
                number =0; // after each compute, reset num =0 in anticipation of another number
                sign = 1;
            }
            else if (ch == '-') {
                result += number * sign;
                number =0;
                sign = -1;
            }
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result += number * sign;
                int prevSign = stack.pop(); // sign in front of bracket
                int prevRes = stack.pop(); // result before open bracket
                result = prevRes + result * prevSign; 
                number = 0;
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
        
    }
}
