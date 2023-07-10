class MyLinkedList {
    class node{
        int val;
        node next;
        public node(int val){
            this.val = val;
            next = null;
        }
    }
   
  node head = null;
  int size=0;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>=size){
            return -1;
        }else{
            node p = head;
            for(int i=0;i<index;i++){
                p = p.next;
            }
            return p.val;
        }
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        node n = new node(val);
        size++;
        if(head == null){
            head = n;
        }else{
            n.next = head;
            head = n;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        node n= new node(val);
        size++;
        if(head == null){
            head = n;
        }else{
            node ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = n;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
                 if(index>size){
                     return;
                 }else if(index == 0){
                     addAtHead(val);
                     
                 }else{
                     size++;
                     node ptr = head;
                     for(int i=0;i<index-1;i++){
                         ptr = ptr.next;
                     }
                     node n = new node(val);
                     n.next = ptr.next;
                     ptr.next =n;
                 } 
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size){
            return;
        }else{
            size--;
            node ptr = head;
            for(int i=0;i<index-1;i++){
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
           
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */