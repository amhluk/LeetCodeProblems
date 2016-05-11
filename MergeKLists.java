// 23. Merge k Sorted Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /* MINHEAP SOLUTION
    
    private static Comparator<ListNode> listComparator = 
        new Comparator<ListNode>() {
          @Override
          public int compare(ListNode x, ListNode y) {
              return x.val - y.val;
          }
        };
        
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, listComparator);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        while(!queue.isEmpty()) {
            curNode.next = queue.poll();
            curNode = curNode.next;
            if (curNode.next != null) {
                queue.add(curNode.next);
            }
        }
        return dummyHead.next;
    } */
    
    /* DIVIDE AND CONQUER SOLUTION */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    
    // from 21. Merge Two Sorted Lists
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