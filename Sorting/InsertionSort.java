



public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> status = new ArrayList<>();
        //status.add(new ArrayList<Pair> (pairs));
        for (int i=0; i<pairs.size(); i++) {
            int j = i;
            while (j>0 && pairs.get(j).key < pairs.get(j-1).key) {
                Pair temp = pairs.remove(j);
                pairs.add(j-1, temp);
                j--;
            }
            status.add(new ArrayList<Pair> (pairs));
        }
        return status;

    }
}
