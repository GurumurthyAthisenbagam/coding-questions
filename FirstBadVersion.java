/**
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
**/

/**
Explanation:
Binary Search Approach: Instead of checking every version sequentially (O(n)), we use binary search (O(log n)).
Avoiding Overflow: The calculation mid = left + (right - left) / 2 prevents potential integer overflow.
Finding the First Bad Version:
If isBadVersion(mid) is true, then the first bad version must be at mid or earlier, so we move right to mid.
If isBadVersion(mid) is false, then the first bad version must be after mid, so we move left to mid + 1.
Loop Termination: The loop stops when left == right, ensuring left points to the first bad version.
**/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid;  // Move right pointer to mid
            } else {
                left = mid + 1;  // Move left pointer to mid + 1
            }
        }
        
        // Check if no bad version is found
        if (left > n || !isBadVersion(left)) {
            return -1;  // Indicating no bad version
        }
        
        return left;  // Return the first bad version
    }
}
