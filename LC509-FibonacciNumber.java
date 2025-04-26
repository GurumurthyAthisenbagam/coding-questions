class Solution {

    Map<Integer, Integer> fibMap = new HashMap<>();
    public int fib(int n) {

        if(n==0) return 0;
        if(n==1) return 1;

        if (fibMap.containsKey(n)) {
            return fibMap.get(n);
        }

        int result = fib(n-1) + fib(n-2);

        fibMap.put(n, result);

        return result;
        
    }
}
