/**
Algorithm
Insert(val)

If val exists in the map, return false.
Append val to the list.
Store its index in the map.
Return true.
Remove(val)

If val does not exist in the map, return false.
Swap val with the last element in the list.
Update the map with the new index.
Remove val from the list and the map.
Return true.
GetRandom()

Pick a random index from the list and return the element.

 */

class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();  // val -> index
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            // if you add to list here, list.size()-1, if you update list after map;  map.put(val, list.size())
            map.put(val, list.size()-1); 
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            // swap last val in list with current val to remove
            int lastVal = list.get(list.size()-1);
            int currentIndex = map.get(val);

            list.set(currentIndex, lastVal);
            list.remove(list.size()-1); // remove last val from the list since its moved to val's location
            map.put(lastVal, currentIndex); // update last val location on map
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        //System.out.println("list: " + list.toString());
        int randomIndex = random.nextInt(list.size());

       //int randomIndex = Math.random(list.size()-1);

        return list.get(randomIndex);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
