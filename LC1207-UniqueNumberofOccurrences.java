class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> freqMap = new HashMap<>(); // num -> count

        for (int n: arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        Set countSet = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if(countSet.contains(entry.getValue())) {
                return false;
            }
            countSet.add(entry.getValue());
        }

        return true;
        
    }
}

/***

alternatively you can check
return freqMap.size() == new HashSet<>(freqMap.values()).size();

 */
