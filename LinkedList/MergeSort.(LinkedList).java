/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
      if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
        
    }
    public static ListNode merge(ListNode l1,ListNode l2){
       ListNode new_head = new ListNode(-1);
        ListNode ptr1 = new_head;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                ptr1.next = l1;
                l1 = l1.next;
                ptr1 = ptr1.next;
            }else{
                ptr1.next = l2;
                l2 = l2.next;
                ptr1 = ptr1.next;
            }
        }
        if(l1 != null){
            ptr1.next = l1;
        }
        if(l2 != null){
            ptr1.next = l2; 
        }
        return new_head.next;
    }
}
