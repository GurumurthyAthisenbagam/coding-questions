class Solution {
    public String addStrings(String num1, String num2) {

        int sum = 0;
        int carry = 0;

        int i = num1.length()-1;
        int j = num2.length()-1;

        StringBuilder str = new StringBuilder();

        while (i>=0 || j>=0 || carry !=0) {
            int digit1 = (i>=0) ? num1.charAt(i) - '0': 0;
            int digit2 = (j>=0) ? num2.charAt(j) - '0': 0;

            sum = digit1 + digit2 + carry;

            str.append(sum%10);
            carry = sum/10;

            i--;
            j--;
        }


        return str.reverse().toString();
    }
}
