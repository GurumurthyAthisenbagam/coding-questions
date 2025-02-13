/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
**/

/* solution complexity 
Time Complexity: O(n) (Each element is processed once)
Space Complexity: O(n) (In the worst case, we store all elements in the HashMap) 
*/
public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> numberMap = new HashMap<>();
        int ret[] = new int[2];

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int difference = target-num;
            if(numberMap.get(difference)!=null){
                
             ret[0] = i;
             ret[1] = numberMap.get(difference);
                return ret;
            }
            numberMap.put(num, i);
        }
        return ret;
    }
}

/**
Optimal Approach: HashMap (O(n) Time Complexity)
Using a HashMap, we can store visited numbers and their indices while iterating through the array. This helps us check if the complement (target - num) already exists in O(1) time.

Approach
Initialize a HashMap<Integer, Integer> to store numbers and their indices.
Iterate through nums:
Compute the complement: target - nums[i]
If the complement exists in the HashMap, return the indices [index of complement, i]
Otherwise, store nums[i] in the HashMap with its index.
Since there is exactly one solution, we are guaranteed to find the answer.
**/
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[]{}; // This line will never be reached because the problem guarantees one solution
    }
}

