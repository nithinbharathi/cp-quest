/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         Queue<Integer>min_heap = new PriorityQueue<>();
         ListNode result = new ListNode(-1);
         ListNode ptr = result;
         for(ListNode head:lists){
             while(head != null){
                 min_heap.add(head.val);
                 head = head.next;
             }
         }
        while(!min_heap.isEmpty()){
            ListNode node = new ListNode(min_heap.remove());
            ptr.next = node;
            ptr = ptr.next;
            
        }
        return result.next;
    }
}
