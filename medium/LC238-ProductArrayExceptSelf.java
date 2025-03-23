/***
answer[i] = prefix_product[i] * suffix_product[i]

Use output array to store prefix product
Use output array to store suffix product
Do a right-to-left pass to multiply with suffix product

 */

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        System.out.println("prefix: ");
        
        for (int i =1; i<n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
            System.out.println(prefix[i] + " ");
        }

        System.out.println("suffix: ");
        for (int i =n-2; i>=0 ; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
            System.out.println(suffix[i] + " ");

        }

         for (int i =0; i<n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

       
        
        return res;
    }
}
