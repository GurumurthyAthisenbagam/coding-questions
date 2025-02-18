/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true



Complexity: O(n)


 */

/**
Approach: Using a Stack (LIFO Data Structure)
We use a stack to store opening brackets. When a closing bracket appears:

If the stack is empty, it's invalid.
If the top of the stack matches the closing bracket, pop it.
If it doesn’t match, return false.
At the end, if the stack is empty, return true; otherwise, false.


**/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        Set<Character> openBraces = new HashSet<>();
        openBraces.add('{');
        openBraces.add('(');
        openBraces.add('[');
    

        for (char ch: s.toCharArray()) {
            if(ch == '{' || ch == '(' || ch == '[') {
                charStack.push(ch);
            }
            else {
                if(charStack.isEmpty()){
                    return false;
                }
                char stackTop = charStack.peek();
                if(ch == '}' && stackTop == '{') {
                    charStack.pop();
                } 
                else if(ch == ')' && stackTop == '(') {
                    charStack.pop();
                }
                else if(ch == ']' && stackTop == '[') {
                    charStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(charStack.isEmpty())
            return true;
        else
            return false;
    }
}
