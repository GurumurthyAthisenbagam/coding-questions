class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) res.add(Arrays.asList(new Integer[]{ lower, upper}));

        for (int i=0; i<nums.length; i++) {
            if (i == 0 && nums[i] >lower) {
                res.add(Arrays.asList(new Integer[]{ lower, nums[i] - 1}));
            }

            if(i == nums.length-1 && nums[i] < upper) {
                res.add(Arrays.asList(new Integer[]{nums[i] + 1, upper}));
            }

            //System.out.println("i: " +i + " nums[i] : " + nums[i]);
            if (i<nums.length-1 && nums[i] + 1 == nums[i+1]) {
                continue;
            }
            else if (i<nums.length-1) {
                res.add(Arrays.asList(new Integer[]{nums[i] + 1, nums[i+1]-1}));
            }
        }


        return res;
    }
}
