/**
Optimal Approach: Breadth-First Search (BFS)
Since we are spreading the rot level by level (minute by minute), BFS is the best approach.

Algorithm:
Find all initially rotten oranges (2) and store them in a queue.
Perform BFS (level-order traversal):
Process each rotten orange and spread the rot to its adjacent fresh oranges.
Count minutes taken.
Check if all fresh oranges have rotted:
If some fresh oranges remain, return -1.
Otherwise, return the total minutes.

 */


class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutesTaken = 0;

        // find all rotten oranges and add it to the queue
        for (int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r,c});
                }
                else if(grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        // all oranges are rotten. 0 minutes. 
        if(freshOranges==0) return 0;

        int[][] neighbours = {{0,-1},{0,1},{1,0},{-1,0}}; // left right top bottom

        

        // Do BFS of rotten oranges.
        // pop a rotten orange, mark all neighbours as rotten
        // put the rotten oranges into the queue.
        // increment the minutes taken 
        while(!queue.isEmpty()) {
            // we have to process all rotten oranges at one go level by level
            // to do that we have to process the entire queue in one go
            int size = queue.size(); // Number of oranges to process in the current minute
            boolean rotted = false;


            // process orangles level by level
            // after each level processed a minute of over and more rotting happen
            // since we add neighbours to queue we process them next in next minute
            for (int i = 0; i < size; i++) { 

                int[] rotten = queue.poll();
                int rottenRowIndex = rotten[0];
                int rottenColIndex = rotten[1];
                int rowMax= grid.length;
                int colMax= grid[0].length;

                // mark neighbours as rotten
                for (int[] index: neighbours) {
                    int currentRowIndex =rottenRowIndex+index[0];
                    int currentColIndex = rottenColIndex+index[1];
                    if(currentRowIndex<0 || currentColIndex<0 || 
                    currentRowIndex >= rowMax ||
                    currentColIndex >= colMax || 
                    grid[currentRowIndex][currentColIndex] != 1) {
                        continue;
                    } 
                    else {
                    grid[currentRowIndex][currentColIndex] = 2;
                    queue.add(new int[] {currentRowIndex,currentColIndex});
                    freshOranges--;
                    rotted = true;
                    }
                }
            }  
           if(rotted) minutesTaken++; // after processing each level increment the minute.
        }

        return freshOranges==0?minutesTaken:-1;

    }

        
}
