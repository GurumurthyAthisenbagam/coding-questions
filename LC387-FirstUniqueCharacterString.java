class Solution {
    public int firstUniqChar(String s) {

        if(s==null || s.length() ==0) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

       for (int i = 0;i<s.length(); i++) {
        if(freqMap.get(s.charAt(i)) == 1) {
            return i;
        }
       }  
       return -1;      
    }
}
