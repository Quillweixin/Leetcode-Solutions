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
        // special cases;
        if(m==n) return head;
        
        ListNode start = head;
        ListNode cur = start,next=cur.next,nodem=cur;
        int count = 1;
        while(true){
            if(count>=n) break;
            // the (m-1)th node is stored as the start node.
            if(count<m){
                if(count<m-1) start = start.next;
                cur = cur.next;
                next = next.next;
                count++;
                continue;
            }
            // the mth node is stored as nodem.
            if(count == m) nodem = cur;
            ListNode nextnext = next.next;
            next.next = cur;
            cur = next;
            next = nextnext;
            count++;
        }
        // when m==1, "head" is no more the head of the linkedlist
        if(m==1) {
            nodem.next = next;
            return cur;
        }
        start.next = cur;
        nodem.next = next;
        return head;
    }
}