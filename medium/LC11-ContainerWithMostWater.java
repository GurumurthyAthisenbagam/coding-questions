/**
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.


Short Version of the Algorithm
Initialize Two Pointers: Start with one pointer at the beginning (left) and one at the end (right) of the array.
Calculate Area: At each step, calculate the area formed by the lines at the two pointers (i.e., min(height[left], height[right]) * (right - left)).
Update Maximum Area: Keep track of the maximum area found.
Move Pointer: Move the pointer corresponding to the shorter line inward, as this is the only way to possibly increase the area.
Repeat: Continue until the two pointers meet.

Complexity Analysis
Time Complexity: O(n) – Each pointer moves at most n times.
Space Complexity: O(1) – Only constant extra space is used.

 */

class Solution {
    public int maxArea(int[] height) {

        // right-left= width
        // height = min(left hight and right height)
        // area = height * width 

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        if(height.length == 1) return -1;

        while(left<right) {
            
            int area = (right-left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
