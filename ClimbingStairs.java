/**
Fibonacci with memoization
**/

class Solution {
    int count=0;
    Map<Integer, Integer> countMap = new HashMap<>();
    public int climbStairs(int n) {
        return count(n);
    }

    public int count(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        if(!countMap.containsKey(n-1)){
            countMap.put(n-1, count(n-1));
        }
        if(!countMap.containsKey(n-2)){
            countMap.put(n-2, count(n-2));
        }

        return countMap.get(n-2) + countMap.get(n-1);

    }
}
