/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null )
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode next = null;
        int size =0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        while(size>=k){
            curr = prev.next;
            next = curr.next;
            for(int i = 1;i<k;i++){
               
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
                
            }
            prev = curr;
            size -=k;
        }
       return dummy.next; 
    }
}
