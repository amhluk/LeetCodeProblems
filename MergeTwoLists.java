// 21. Merge Two Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        for (;;) {
            // add remaining list to curNode if either is null and break
            if (l1 == null) {
                curNode.next = l2;
                break;
            } else if (l2 == null) {
                curNode.next = l1;
                break;
            }
            
            // compare values
            if (l1.val > l2.val) {
                curNode.next = l2;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                l1 = l1.next;
            }
            curNode = curNode.next;
        }
        return dummyHead.next;
    }
}