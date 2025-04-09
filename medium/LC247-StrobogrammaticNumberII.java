/**
Use DFS (Backtracking).
Build numbers from outside in (left and right together).
Handle even and odd length carefully:
If n is odd, middle element must be 0, 1, or 8.
Avoid numbers that start with 0 (except if the number is just 0).
 */
class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }

    public List<String> build(int n, int totalLength) {
        if (n==0) return Arrays.asList("");
        if (n==1) return Arrays.asList("1" , "8" , "0");

        List<String> list =   build(n-2, totalLength);

        List<String> res = new ArrayList<>();
        for (String s: list) {
            if (n<totalLength) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }

        return res;
    }



}
