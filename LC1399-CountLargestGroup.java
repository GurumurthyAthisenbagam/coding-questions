class Solution {
    public int countLargestGroup(int n) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq =0;

        for(int i=1; i<=n; i++) {
            int digitSum = getDigitsSum(i);
            freqMap.put(digitSum, freqMap.getOrDefault(digitSum, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(digitSum));
        }

        int count =0;
        for(int freq: freqMap.values()){
            if(freq == maxFreq) count++;
        }

        return count;
    }

    int getDigitsSum(int num) {
        int sum =0;
        while(num>0) {
            sum = sum + num%10;
            num = num/10;
        }

        return sum;
    }
}
