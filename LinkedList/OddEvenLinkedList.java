/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ptr_odd  = head;
        ListNode even = head.next;
        ListNode ptr_even = even;
        while(ptr_even != null && ptr_even.next != null){
            ptr_odd.next = ptr_even.next;
            ptr_odd = ptr_odd.next;
            ptr_even.next = ptr_odd.next;
            ptr_even = ptr_even.next;
        }
        ptr_odd.next = even;
      
        return head;
    }
}
