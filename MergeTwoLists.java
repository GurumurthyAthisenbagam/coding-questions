/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
**/

/**

Optimal Approach: Iterative Merge (O(N))
We maintain a dummy node to simplify merging and a pointer current to build the result.

Create a dummy node (prehead) and a pointer (current) to track the merged list.
Traverse both lists:
Compare list1.val and list2.val.
Append the smaller value to current.next and move the corresponding list pointer.
If one list remains, append it directly to current.next.
Return prehead.next as the new merged list head.

**/



/** public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       }


**/


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode(); 
        ListNode current = dummyHead;

        while(list1!=null && list2!=null) {
            if(list1.val == list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
            else if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
                current.next = null;
            }
            else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
                current.next = null;
        }

    }

    if(list2 != null){
            current.next = list2;
     }
    if(list1 != null){
            current.next = list1;
    }

    return dummyHead.next;
}
}
