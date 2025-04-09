class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        if (word.equals("") || abbr.equals("")) return false;
        
        int i=0, j=0;
        
        while(i<word.length() && j < abbr.length()) {

            if (Character.isDigit(abbr.charAt(j))){
                if(abbr.charAt(j) == '0') return false;
                int numStart = j;
                while ( j<abbr.length() && Character.isDigit(abbr.charAt(j)))  {
                    j++;
                }
                if (numStart != j) {
                    int num = Integer.valueOf(abbr.substring(numStart, j));
                    i = i + num;
                }
            } 
            else {
                if(i>=word.length() || word.charAt(i) != abbr.charAt(j)) return false;
            
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
