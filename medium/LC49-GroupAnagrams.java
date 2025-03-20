/**
Approach 1: Sorting Strings (Using HashMap)

Intuition
Anagrams have the same characters in the same frequency.
Sorting an anagram results in the same key.
Use a HashMap:
Key: Sorted word.
Value: List of words that match the sorted key.

Algorithm
Create a HashMap → Key = sorted word, Value = List of anagrams.
Iterate through words:
Sort each word.
Use sorted word as key.
Add original word to the list.
Return the grouped lists.

Time Complexity
O(n * k log k) → k log k for sorting each word, n words.
O(nk) Space Complexity → Storing all words.


 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap();
        List<List<String>> res = new ArrayList();


        for(String str: strs) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String anaString = new String(cArr);
            List<String> list = map.get(anaString);
            if(list == null) {
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(anaString, list);
        }
        
        

        return new ArrayList(map.values());
    }
}
