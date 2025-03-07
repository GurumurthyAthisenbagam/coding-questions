class Solution {
    public int longestPalindrome(String s) {

        if(s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch: s.toCharArray()) {
            // if(!charCountMap.containsKey(ch)) {
            //     charCountMap.put(ch, 1);
            // }
            // else {
            //     int count = charCountMap.get(ch);
            //     charCountMap.put(ch, (count + 1));
            // }
            charCountMap.put(ch,charCountMap.getOrDefault(ch,0)+1);
        }

        int longestPalindrome=0 ;
        boolean hasOdd = false;
        for (Map.Entry entry: charCountMap.entrySet()) {
            Integer currCharCount = (Integer) entry.getValue();
            if (currCharCount%2 == 0) {
                longestPalindrome += currCharCount;
            } 
            else {
                // for odd ignore one char and use remaining
                //if(currCharCount > 2)
                longestPalindrome += (currCharCount-1);
                hasOdd = true;
            }
        }
        if (hasOdd) longestPalindrome++; 

        return longestPalindrome;
    }
}
