/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>=n || head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode one = head;
        ListNode next = null;
        ListNode prev = null;
        int i=1;
        
        while(i<m){
            p = one;
            one = one.next;
            i++;
        }
        prev = one;
        ListNode curr = one.next;
        while(i<n){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        one.next = curr;
        p.next = prev;
        return dummy.next;
    }
}
