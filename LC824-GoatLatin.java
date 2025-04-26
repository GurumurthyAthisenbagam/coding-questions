public class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (vowels.indexOf(word.charAt(0)) >= 0) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(word.charAt(0));
            }
            
            result.append("ma");
            
            // Append (i+1) 'a's
            for (int j = 0; j <= i; j++) {
                result.append('a');
            }
            
            if (i != words.length - 1) {
                result.append(' ');
            }
        }
        
        return result.toString();
    }
}



/** class Solution {
    public String toGoatLatin(String sentence) {
        String[] words =  sentence.split(" ");

        for (int i=0; i<words.length; i++) {
            char first = words[i].charAt(0);
            if (isVowel(first)) {
                words[i] = words[i] + "ma";
            }
            else {
                words[i] = words[i].substring(1) + first + "ma";
            }

            for (int j=0; j<=i; j++) {
                words[i] = words[i] + "a";
            }
        }

        return String.join(" ", words);
    }

    boolean isVowel(char ch) {
        if (ch =='a' || ch =='e' || ch =='i' ||ch =='o' ||ch =='u' 
        ||ch =='A' || ch =='E' || ch =='I' ||ch =='O' ||ch =='U') {
            return true;
        }
        return false;
    }
}

**/
