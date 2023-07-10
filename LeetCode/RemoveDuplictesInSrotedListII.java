/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
       ListNode first  =  head;
       ListNode second = first.next;
       ListNode dummy = new ListNode(0);
      ListNode ptr = dummy;
        if(first.val != first.next.val){
            ListNode n = new ListNode(first.val);
            ptr.next = n;
            ptr = ptr.next;
        }
        while(second.next != null){
            if(second.val != first.val && second.val != second.next.val){
                ListNode s = new ListNode(second.val);
                ptr.next = s;
                ptr = ptr.next;
            }
            first = second;
            second = second.next;
        }
        if(second.val != first.val){
            ListNode s = new ListNode(second.val);
                ptr.next = s;
                ptr = ptr.next;
        }
        return dummy.next;
    }
}
