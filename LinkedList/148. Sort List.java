// merge sort a linked list
// time complexity: O(nlogn)  space complexity: O(longn)

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head, fast = head, prev = null;
        // partitioning the list.
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // recursively partitioning
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left,right);
    }
    
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0), cur = head;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null){
            cur.next = l1;
        }
        return head.next;
    }
}