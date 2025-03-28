/**
O(nlog(k)) 
n is size of matrix
k is the size of maxHeap - O(log K)
**/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        // maxHeap
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);

        for(int[] row: matrix) {
            for(int cell: row) {
                q.offer(cell);
                if(q.size()>k) {
                    q.poll();
                }
            }
        }


        return q.peek();
    }
}
