class Solution {
    public boolean isStrobogrammatic(String num) {

        // 0, 1, 8, 6, 9 valid numbers

        Map<Character, Character> rotateMap = new HashMap<>();
        rotateMap.put('0','0');
        rotateMap.put('1','1');
        rotateMap.put('8','8');
        rotateMap.put('6','9');
        rotateMap.put('9','6');
        
        int left = 0;
        int right = num.length()-1;

        while (left<=right) { // for odd numlength to check middle character check left == right 
            if(!rotateMap.containsKey(num.charAt(left)) || !rotateMap.containsKey(num.charAt(right))) return false;
            if (num.charAt(left) != rotateMap.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;


    }
}
