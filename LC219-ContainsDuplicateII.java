/**
You can also use a Map (num -> last index) to track last seen positions
O(n) time, but directly compares indices
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> indexMap = new HashMap<>(); // value -> index
        
        for (int i =0; i < nums.length; i++) {
            if(indexMap.containsKey(nums[i])) {
                int originalIndex = indexMap.get(nums[i]);
                if (Math.abs(i-originalIndex) <= k) {
                    return true;
                } 
            }
            indexMap.put(nums[i], i);
        }

        return false;
        
    }
}
