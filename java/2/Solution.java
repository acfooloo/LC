/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public class ListNode {
 		int val;
 		ListNode next;
 		ListNode(int x) { val = x; }
 	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = _addTwoNumbers(l1, l2, 0);
        if (ret == null) {
            ret = new ListNode(0); //***
        }
        return ret;
    }

    public ListNode _addTwoNumbers(ListNode l1, ListNode l2, int co) {
    	int v1 = 0, v2 = 0;
    	if (l1 != null) {
    		v1 = l1.val;
    		l1 = l1.next;
    	}
    	if (l2 != null) {
    		v2 = l2.val;
    		l2 = l2.next;
    	}
    	int total = v1 + v2 + co;
    	if (total == 0 && l1 == null && l2 == null) { //***
    		return null;
    	}
    	ListNode ret = new ListNode(total % 10);
    	ret.next = _addTwoNumbers(l1, l2, total / 10);
    	return ret;
    }

}