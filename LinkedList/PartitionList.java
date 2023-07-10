/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1),s_ptr = small, l_ptr = large;
        while(head != null){
           if(head.val<x){
                s_ptr.next = head;
                head = head.next;
                s_ptr = s_ptr.next;
            }else if(head.val>=x){
                l_ptr.next = head;
                head = head.next;
                l_ptr = l_ptr.next;
            }
            
        }
        s_ptr.next = large.next;
        l_ptr.next = null;
        return small.next;
    }
}
