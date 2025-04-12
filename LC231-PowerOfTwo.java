/**
There is no power of 2 for negative numbers so return false for neative numbers.

we are looking for numbers of bit form
1 follwed by zeros
10
100
1000

so 
8 = 1000
7 = 0111
& operation = 0

return true 

else 
return false

 */

class Solution {
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
        
    }
}

/**
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
 */
