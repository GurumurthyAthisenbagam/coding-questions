/**
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^



 */




class Solution {
    public int myAtoi(String s) {
        if (s == null || s.trim().isEmpty()) return 0;  // handle null or empty input
        
        String input = s.trim();
        boolean negative = false;
        int index = 0;
        
        // Check for negative or positive sign
        if (input.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (input.charAt(index) == '+') {
            index++;
        }

        // Remove leading zeros
        while (index < input.length() && input.charAt(index) == '0') {
            index++;
        }
        
        // If the string becomes empty after removing leading zeros, return 0
        if (index == input.length()) return 0;

        long result = 0;
        
        for (int i = index; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                break;  // stop when non-digit character is found
            }

            // Prevent overflow
            int digit = ch - '0';
            
            result = result * 10 + digit;
            
            if (result > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        // Apply negative sign if necessary
        return (int) (negative ? -result : result);
    }
}


/**

result = result * 10 + (ch - '0');  312
0+3 = 3
30+1 = 31
310+2

res += (s1.charAt(i)-'0')*Math.pow(10,s1.length()-i-1);
300
300+10 = 310
310+2

**/
