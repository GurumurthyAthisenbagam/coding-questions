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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp;
        ListNode i = head;
        ListNode j = head.next;
        ListNode k;
        i.next = null;

                
        while(j!=null){
            k= j.next;
            j.next = i;
            i=j;
            j=k;
        }

        return i;
    }
     
}

/** 

5->4->3->2->1

1->2->3->4->5
i j  k

1<-2 3->4->5
i  j k
1<-2 3->4->5
   i kj
1<-2 3->4->5
   i j  k
1<-2<-3->4->5
   i j  k
1<-2<-3 4->5
      i j/k
1<-2<-3 4->5
      i  j k
1<-2<-3<-4 5
      i. j k
1<-2<-3<-4 5
         i  j. k=null 
1<-2<-3<-4<-5
         i. j. 
1<-2<-3<-4<-5
            i. j=null k=null       

**/
