/**

All 0 cells are sources.
All 1 cells need to find the nearest 0.
Use multi-source BFS: start BFS from all 0s at the same time. 

Queue: Start by adding all 0 cells to a queue.
BFS: Expand layer by layer — updating neighboring 1s with distance = previous distance + 1.
Visited: Mark cells as visited or update their values directly.

*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        // add all locations with '0' to queue
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] neighbors = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}} ;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int[] neighbor: neighbors) {
                int neighRow = row + neighbor[0];
                int neighCol = col + neighbor[1];
                if(neighRow>=0 && neighCol >=0 && neighRow<mat.length &&  neighCol<mat[0].length && mat[neighRow][neighCol] == -1){
                    mat[neighRow][neighCol] = mat[row][col] + 1;
                    queue.offer(new int[]{neighRow, neighCol});
                }
            }
        }
        
        return mat;
    }
}
