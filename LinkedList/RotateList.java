/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int i=0;
        if(head == null || head.next ==null){
            return head;
        }
        while(i<k){
            ListNode ptr1 = head;
            ListNode ptr2 = null;
            while(ptr1.next != null){
                ptr2 = ptr1;
                ptr1 = ptr1.next;
            }
            ptr1.next = head;
            head = ptr1;
            ptr2.next = null;
            i++;
        }
        return head;
    }
}
