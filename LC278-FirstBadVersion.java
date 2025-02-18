/**
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 

Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1
 

Constraints:

1 <= bad <= n <= 231 - 1


**/

/**
Optimal Approach: Binary Search (O(log N))
Since versions are in sorted order (good → bad), we can use Binary Search:

Start with left = 1 and right = n.
Find the middle version: mid = left + (right - left) / 2.
If isBadVersion(mid) == true:
The first bad version is at mid or before (right = mid).
Otherwise, move left forward (left = mid + 1).
The loop stops when left == right, which gives the first bad version.

**/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); 
      
      sorted list
      mid = left + (right-left)/2;
      
      */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        // because input is size or array/list we assume that it is not zero
        int left = 1; 
        int right = n;
        int mid;

        while(left<right) {
            mid = left + (right-left)/2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid +1;
            }
        }
        // This is check is for when there is no bad version, 
        // the left will go all the way to end of the list. 
        if(left > n || !isBadVersion(left)) {
            return -1;
        }
        return left;
    }
}
