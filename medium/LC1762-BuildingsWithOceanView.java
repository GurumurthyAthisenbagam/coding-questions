/**
Start from last building (rightmost)
Track maximum height seen so far
Collect indices where building height > maxHeightSoFar
✅ Easy and efficient!
 */

class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int maxHeight = -1;

        for (int i=heights.length-1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                result.add(i); // returning the index of buildings
                maxHeight = heights[i]; 
            }
        }

        Collections.reverse(result); // sorted in incresing order

        return result.stream().mapToInt(Integer:: intValue).toArray();
        
    }
}
