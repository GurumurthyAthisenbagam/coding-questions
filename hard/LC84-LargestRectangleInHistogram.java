class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
        return maxArea;
    }
}


/**
brute force - O(n2)
at each bar, 
find leftmost until you hit bar with height less than current bar; intitial leftmost = i
find righttmost until you hit bar with height less than current bar; intitial rightmost = i+1


public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int leftMost = 0;
        int rightMost = n-1;
        int maxArea = Integer.MIN_VALUE;;

        for (int i=0; i<n; i++) {
            int currHeight = heights[i];
            leftMost = i;
            rightMost = i+1;

            while (leftMost>=0 && heights[leftMost] >= currHeight) {
                leftMost--;
            }

            while (rightMost<n && heights[rightMost] >= currHeight) {
                rightMost++;
            }

            rightMost--;
            leftMost++;

            maxArea = Math.max(maxArea, (rightMost-leftMost+1) * currHeight);
        }

        return maxArea;
    }


 */
