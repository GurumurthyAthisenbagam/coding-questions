class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<>();

        result = getAllCombinations(nums);
        result.add(emptySet);

        return result;
        
    }

    List<List<Integer>> getAllCombinations(int[] arr){
        List<List<Integer>> result = new ArrayList<>();

        for (int i=1; i<=arr.length;i++) {
            getCombination(arr,i,0,result, new ArrayList<>());
        }

        //System.out.println(result);

        return result;
    }

    public void getCombination(int[] arr, int length, int start, List<List<Integer>> result, List<Integer> current) {
       if(current.size() == length) {
           result.add(new ArrayList<>(current));
           return;
       }

       for (int i=start;i<arr.length; i++) {
           current.add(arr[i]);
           getCombination(arr,length, i+1,result, current);
           current.remove(current.size()-1);
       }

       return;
    }
}
