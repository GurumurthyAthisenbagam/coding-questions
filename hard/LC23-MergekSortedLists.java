/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        

        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode list: lists) {
            while(list!= null) {
                minHeap.offer(new ListNode(list.val));
                list = list.next;
            }
        }

        ListNode rootNode = minHeap.poll();
        ListNode currentNode = rootNode;

        while(!minHeap.isEmpty()) {

            currentNode.next = minHeap.poll();
            currentNode = currentNode.next;


        }

        if(currentNode!=null) currentNode = null;


        return rootNode;
        
    }
}
