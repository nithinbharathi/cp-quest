/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ptr1 = head;
        ListNode prev = null;
        ListNode n ;
        while(ptr1 != null){
            n = ptr1.next;
            ptr1.next = prev;
            prev = ptr1;
            ptr1 = n;
        }
        head = prev;
        return head;
        
        
    }
}