/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode tail=head,toDelete=head;
        for(int i = 0;i<n;i++){
            tail = tail.next;
        }
        while(tail!=null){
            toDelete = toDelete.next;
            tail = tail.next;
            guard = guard.next;
        }
        // deleting the tail
        if(toDelete.next==null){
            guard.next = null;
            return head;
        }
        toDelete.val = toDelete.next.val;
        toDelete.next = toDelete.next.next;
        return head;
    }
}