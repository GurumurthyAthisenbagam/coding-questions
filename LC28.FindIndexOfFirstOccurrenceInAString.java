class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = needle.length()-1;

        if (needle == null || needle.length() == 0) return 0;

        while (j <haystack.length()) {
            if (haystack.substring(i, j+1).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }
}
