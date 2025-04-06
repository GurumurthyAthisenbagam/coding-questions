/**
while new intervals start time is greater than current intervals end time add as is
while new interval's end time is greater than current intervals start time merge interval
Add remaining

 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i=0;
        int n = intervals.length;;

        while (i<n && newInterval[0] > intervals[i][1] ) {
                result.add(intervals[i]);
                i++;
        }
        
        while (i<n && newInterval[1] >= intervals[i][0]) {
            // have to perform merge on the newInterval itself
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i<n) {
                result.add(intervals[i]);
                i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
