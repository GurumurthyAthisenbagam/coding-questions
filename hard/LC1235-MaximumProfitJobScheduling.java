/**
Approach: DP + Binary Search
We’ll solve it like this:

1. Preprocessing:
Create a Job class to hold each job's (start, end, profit)
Sort jobs by end time

2. Dynamic Programming:
Use dp[i] = max profit for first i jobs (sorted by end time)
For each job i:

Either:
Take the job: add its profit + best profit for job that ends before this job starts
Skip the job: carry over previous dp[i-1]
Use binary search to find the last job that ends before start[i]
 */

class Solution {

    class Job {
            int startTime;
            int endTime;
            int profit;

            Job (int startTime, int endTime, int profit) {
                this. startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        
        int n = startTime.length; // all arrays are of same length
        Job[] jobs = new Job[n];

        for (int i=0; i<n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a,b) -> a.endTime - b.endTime);

        int dp[] = new int[n]; // we store the maximum profit at each index
        dp[0] = jobs[0].profit;

        for(int i=1; i<n ;i++) {
            int currProfit = jobs[i].profit;

            int lastIndex = binarySearch(jobs, i);
            if (lastIndex != -1) {
                currProfit += dp[lastIndex];
            }

            dp[i] = Math.max(dp[i-1], currProfit);

        }

        return dp[n-1];
    }

    int binarySearch (Job[] jobs, int index) {
        int target = jobs[index].startTime;
        int low = 0;
        int high = index-1; // setting the Binary search range to less than current indes

        while(low <= high) {

            int mid = high+low/2;

            if (jobs[mid].endTime <= target) { // at mid, the job ends before the current startTime
                if (mid == high || jobs[mid+1].endTime >=target) {
                    return mid;
                }
                low = mid + 1; 
// mid is valid but there might be another job that ends earlier also and increase profit. so we go right instead of left. 
                
            }
            else {
                high = mid - 1;
            }

        }
        return -1;
    }
}
