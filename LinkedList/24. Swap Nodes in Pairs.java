/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode left = head;
        ListNode right = left.next;
        ListNode res = head.next;
        while(left!=null && right!=null){
            ListNode next = right.next;
            right.next = left;
            
            if(next == null) {
                left.next = null;
                break;
            }
            if(next.next == null){
                left.next = next;
                break;
            }
            left.next = next.next;
            left = next;
            right = left.next;
            
        }
        
        return res;   
    }
}