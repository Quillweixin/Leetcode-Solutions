/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode first_even = even;
        ListNode nextOdd,nextEven;
        while(odd.next!=null || even.next!=null){
            if(odd.next == null || odd.next.next==null) odd.next=null;
            else{
                nextOdd = odd.next.next;
                odd.next = nextOdd;
                odd = nextOdd;
            }
            if(even.next==null || even.next.next==null) even.next=null; 
            else{
                nextEven = even.next.next;
                even.next = nextEven;
                even = nextEven;
            }
        }
        // connect two parts of linkedList
        odd.next = first_even;
        return head;
    }
}