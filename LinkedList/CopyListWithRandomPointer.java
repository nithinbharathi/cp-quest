/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
         Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
             Node n = new  Node(curr.val);
            curr.next = n;
            n.next = next;
            curr = next;
            
        }
       curr = head;
        while(curr != null){
            if(curr.random != null){
            curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
    curr = head;
    Node h = new Node(-1);
    h.next = head;
    Node copy = h;
    Node copy_ptr = null;
    Node curr_ptr = null;
    while(curr !=null){
          curr_ptr = curr.next.next;
          copy_ptr  = curr.next;
          copy.next =copy_ptr;
          curr.next = curr_ptr;
          curr = curr_ptr;
          copy = copy_ptr;
        
    }
    return h.next;
}
}
