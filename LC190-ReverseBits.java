public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        // loop 32 times since you process 32 bits
        for (int i=0; i<32; i++) {
            result = result << 1; // left shift right once to make space for the reversed bit
            result = result | (n&1); // n&1 will give the right most digit, OR with resault will insert that digit at the end of result
            n = n >>> 1; // three > because of signed digit. right shift to lose that last digit and get the next one
        }
        return result;
    }
}
