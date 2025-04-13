class Solution {
    public char findTheDifference(String s, String t) {

        int xorNum = 0;

        for (char ch: s.toCharArray()) {
            xorNum ^= ch;
        }

        for (char ch: t.toCharArray()) {
            xorNum ^= ch;
        }

        return  (char)(xorNum);
        
    }
}
