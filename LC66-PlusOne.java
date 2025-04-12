class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry =0;

        for (int i=n-1; i>=0 ; i--) {
            if (digits[i]<9) { // whenever num <9 we can add the carry over 1 and stop the addition and return
                digits[i]++;
                return digits;
            }
            digits[i]=0; // when num ==9, current digit becomes 0
        }
        
        int[] res = new int[n+1]; // if every digit is 9, we need to prepend a 1 and then everything will becoe 0
        res[0] = 1;
        return res;
    }
}
