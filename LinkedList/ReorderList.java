/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution{
    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode fast = head;
        ListNode ptr1 =head;
        ListNode ptr2 = null;
        if(head == null || head.next == null){
            return;
        }
        while(fast != null && fast.next != null){
            ptr1 = mid;
            fast = fast.next.next;
            mid = mid.next;
        }
        ptr1.next = null;
        ptr2 = reverse(mid);
        merge(head,ptr2);
        
    }
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;   
        }
        return prev;
    }
    public static void merge(ListNode head , ListNode sec_head){
        while(head !=  null){
        ListNode p1 = head.next;
        ListNode p2 = sec_head.next;
        head.next = sec_head;
            if(p1 == null){
                break;
            }
        sec_head.next = p1;
        head = p1;
        sec_head = p2;
        }
    }
}
