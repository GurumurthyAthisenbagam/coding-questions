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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || k == 0) return head;


        ListNode temp = head;
        int length =1;

        while (temp.next!=null) {
            length++;
            temp = temp.next;
        }
        ListNode tail = temp;


        k= k%length;
        if(k==0) return head;

        int offset = length-k; // length =5, k=2, offset = 2
        //System.out.println(offset);
        ListNode prev = head;
        ListNode current = head;

        for (int i =0; i<offset; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        tail.next = head;

        return current;
    }
}
