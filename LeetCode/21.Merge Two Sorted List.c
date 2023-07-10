/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->val = 0;
    head->next = NULL;
    struct ListNode* ptr = head;
    if(l1 == NULL && l2 == NULL){
        return NULL;
    }
    while(l1 != NULL && l2 != NULL){
        if(l1->val <= l2->val){
            ptr->next = l1;
            l1 = l1->next;
            ptr= ptr->next;
        }
        else{
            ptr->next = l2;
            l2 = l2->next;
            ptr = ptr->next;
        }
    }
    while(l1 != NULL){
        ptr->next = l1;
        l1=l1->next;
        ptr=ptr->next;
    }
    while(l2 != NULL){
         ptr->next = l2;
        l2=l2->next;
        ptr=ptr->next;
    }
    return head->next;
}