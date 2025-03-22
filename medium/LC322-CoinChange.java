class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // default with maximum possible value for minCoins

        dp[0] =0 ; // base case

        for (int i=1; i<=amount ; i++) {
            for(int coin: coins) {
                if (i-coin >= 0) {
                    dp[i] = Math.min(dp[i] , 1 + dp[i-coin]);
                }
            }
        }

        return dp[amount] != amount+1 ? dp[amount]: -1;
        
    }
}




/****


// [1,2,5]
// mincoin = dp[coin] + dp[amount-coin] = 1 + dp[amount-coin] because we know that dp[coin] = 1 i.e. when amount is 5 we use 5 so 1 coin. 
// amount = 7 dp[5] +dp[7-5 =2] 
class Solution {
    Map<Integer, Integer> changeMap = new HashMap(); // map of amount and min coin count

    public int coinChange(int[] coins, int amount) {

         if (amount < 0) return -1;
          if(amount == 0) return 0;

            // for (int coin: coins) {
            //     changeMap.put(coin, 1) ;   this is not needed since it is taken care of in recursion
            // }

            return computeMin(coins, amount);
        
    }

    int computeMin (int[] coins, int amount) {

        int res = -1;

         if (amount < 0) return -1;

        if(amount == 0) {
            return 0;
        }

        if (changeMap.containsKey(amount)) {
            return changeMap.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;

        // amount = dp[coin] + dp[amount-coin]
        for (int coin: coins) {

            int subResult = computeMin(coins, amount-coin);
            if(subResult >=0 && subResult < minCoins)  {
                minCoins = subResult +1;
            }
        }

        res = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;

        changeMap.put(amount, res);

        return res;
    }
}

**/
