/**
Use Hashmap to do counting
get adjacent string with valid condition

 */

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public String findValidPair(String s) {

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for (int i=0; i<s.length()-1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            int num1 = ch1-'0';
            int num2 = ch2-'0';
            // System.out.println("num1: " + num1 + " num2: " + num2);
            if(ch1 != ch2) {
                if(map.get(ch1) == num1 && map.get(ch2) == num2) {
                    return s.substring(i, i+2);
                }
            }
        }

        return "";
        
    }
}
