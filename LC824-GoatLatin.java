class Solution {
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
