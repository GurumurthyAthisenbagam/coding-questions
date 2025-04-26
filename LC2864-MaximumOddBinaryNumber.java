class Solution {
    public String maximumOddBinaryNumber(String s) {

        int n = s.length();
        char[] str = new char[n];
        int ones = 0;

        for (int i=0; i<n ; i++) {
           if (s.charAt(i) == '1') ones++;
        }

       if(ones>0) {
        str[n-1] = '1'; 
        ones--;
       }
        
        for(int i =0; i<n-1; i++) {
            if(ones>0) {
                str[i] = '1';
                ones--;
            }
            else {
                str[i] = '0';
            }
            
        }
        
        return new String(str);
        
    }
}
