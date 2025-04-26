class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index] = nums[left] * nums[left];
                index--;
                left++;
            }
            else {
                res[index] = nums[right] * nums[right];
                index--;
                right--;
            }
        }
        return res;

    }
}

/**
class Solution {
    public int[] sortedSquares(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num: nums) {
            queue.offer(num * num);
        }

        int[] res = new int[queue.size()];
        int i=0;
        while (!queue.isEmpty()) {
            res[i] = queue.poll();
            i++;
        }

        return res;
    }
}
 */
