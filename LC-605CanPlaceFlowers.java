/**
Optimal Approach: Greedy Strategy
Intuition
We iterate through flowerbed and try to plant flowers greedily.
A flower can be planted at flowerbed[i] if both flowerbed[i-1] and flowerbed[i+1] are 0.
After planting, set flowerbed[i] = 1 to avoid double counting.

Algorithm
Traverse the flowerbed and check if flowerbed[i] is empty (0).
Ensure adjacent spots (flowerbed[i-1] and flowerbed[i+1]) are also empty.
If a flower is planted, decrement n.
Return true if n == 0, else return false.

Time Complexity
O(N) → We traverse flowerbed once.
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n==0 || flowerbed.length==0) return true;

        for(int i=0; i<flowerbed.length; i++){
            if (flowerbed[i] == 0) { // cant place flower where already floer is there i.e. 1
                boolean validLeft = (i==0 || flowerbed[i-1] == 0); // i==0 not i>0 because we can place flower at i==0, dont care about beyond i==0
                boolean validRight= (i==flowerbed.length-1 || flowerbed[i+1] == 0);

                if(validLeft && validRight) {
                    flowerbed[i] = 1;
                    n--;
                    if(n==0) return true;
                }
            }
        }

        return n==0? true: false;

    }
}
