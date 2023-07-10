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
        if(head == null || head.next == null)return head;
        ListNode distinct = head;
        while(distinct != null){
            if(distinct.next == null){
                break;
            }
            if(distinct.val == distinct.next.val){
                distinct.next = distinct.next.next;
            }else {
            distinct = distinct.next;
            }
            
        }
        return head;
    }
}
