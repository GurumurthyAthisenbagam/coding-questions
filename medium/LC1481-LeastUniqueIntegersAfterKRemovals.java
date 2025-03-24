/**
Approach:
Count frequencies of all numbers.

Put the frequencies in a min-heap (smallest frequencies first).

While k > 0, remove the least frequent elements first (those easiest to delete).

If frequency ≤ k, remove the whole number and decrement k by that frequency.

When k is too small to remove a full group, stop.

Time and Space Complexity:
Time: O(N + U log U)
N = length of array
U = number of unique integers (for heap)
Space: O(U) — map and heap
 */


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> countMap = new HashMap<>(); // num and frequency

        for (int num: arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(countMap.values());

        //System.out.println(countMap);

        while (!minHeap.isEmpty() && k >0) {
            if (k > 0 && k >= minHeap.peek()) {
                int count = minHeap.poll();
                k = k - count;
            } else { // k <  minHeap.peek()
                int count = minHeap.poll();
                minHeap.add(count-k);
                k = 0; // if you k is not set to 0, you enter loop infinitely
            }
        }

        return minHeap.size();
        
    }
}
