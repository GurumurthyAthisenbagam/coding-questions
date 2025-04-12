class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> nums1Set = new HashSet();
        Set<Integer> nums2Set = new HashSet();

        List<List<Integer>> res = new ArrayList<>();

        for (int n: nums1) {
            nums1Set.add(n);
        }
        
        for (int n: nums2) {
            nums2Set.add(n);
        }

        Set<Integer> res1 = new HashSet<>();
        for (int n: nums1) {
            if(!nums2Set.contains(n)) res1.add(n);
        }

        Set<Integer> res2 = new HashSet<>();
        for (int n: nums2) {
            if(!nums1Set.contains(n)) res2.add(n);
        }

        res.add(new ArrayList(res1));
        res.add(new ArrayList(res2));

        return res;
    }
}
