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
