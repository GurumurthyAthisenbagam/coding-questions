/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 /**
Use DFS (Depth First Search) traversal
Track the current depth while traversing.
If element is an integer → add (value × depth)
If element is a list → recursively explore inside with (depth + 1)
  */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {

        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int sum = 0;
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                NestedInteger current =  queue.poll();
                if(current.isInteger()) {
                    sum = sum + (current.getInteger() * depth) ;
                } else {
                    List<NestedInteger> list = current.getList();
                    queue.addAll(list); // when adding a list to queue use .addAll not .offer
                }

            }

            depth++;
        }

        return sum;
        
    }
}
