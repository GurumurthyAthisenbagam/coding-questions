/** Traverse string left to right:

Push index of '(' onto stack

When you see ')', if stack has '(', pop it (good match)

Else mark this ')' as invalid.

After pass, any leftover '(' in the stack are unmatched → mark them invalid.

Build a new string skipping invalid indexes.

*/

class Solution {
    public String minRemoveToMakeValid(String s) {

        Set<Integer> invalidIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int n = s.length();

        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (ch =='(') {
                stack.push(i);
            }
            else if (ch == ')') {
                if (!stack.isEmpty()){
                    stack.pop();
                }
                else {
                    invalidIndex.add(i);
                }   
            }
        }

        while (!stack.isEmpty()) {
            invalidIndex.add(stack.pop());
        }

        StringBuilder str = new StringBuilder();

        for (int i=0; i<n; i++) {
            if (!invalidIndex.contains(i)) {
                str.append(s.charAt(i));
            } else {
                invalidIndex.remove(i);
            }
        }

        return str.toString();
        
    }
}


