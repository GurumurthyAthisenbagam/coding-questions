class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        getCombinationSum(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    void getCombinationSum(int[] arr, int target, int start, List<List<Integer>> result, List<Integer> current) {
        if (target < 0) {
            return;
        }
        if( target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i=start; i<arr.length;i++) {
            current.add(arr[i]);
            getCombinationSum(arr,target-arr[i], i, result, current);
            current.remove(current.size()-1);
        }
        return;
    }
}
