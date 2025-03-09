/**
Approach to Solve the Problem
Key Insight:

Traverse the Roman numeral from left to right.
If the current symbol's value is less than the next symbol's value, subtract it.
Otherwise, add it to the total.


 */

class Solution {
    Map<Character, Integer> roman = new HashMap<>();

    Solution() {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

    }

    /**
    In some cases, smaller values precede larger values to indicate subtraction:
    IV = 4 (5 - 1)
    IX = 9 (10 - 1)
    XL = 40 (50 - 10)
    XC = 90 (100 - 10)
    CD = 400 (500 - 100)
    CM = 900 (1000 - 100)
     */

    public int romanToInt(String s) {

        int total = 0;

        for(int i=0; i<s.length(); ){
            char ch = s.charAt(i);
            char chNext;
            int valNext = -1;
            if(i<s.length()-1) {
                chNext = s.charAt(i+1);
                valNext = roman.get(chNext);
            }
            
            
            int val = roman.get(ch);
             
            if(val<valNext) {
                total += valNext -val;
                i = i+2;
                continue;
            }
            total += val;
            i++;

        }
        return total;
        
    }
}
