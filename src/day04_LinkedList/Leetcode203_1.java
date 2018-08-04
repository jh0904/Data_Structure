package day04_LinkedList;

/**
 * day04_LinkedList
 *
 * @author jh
 * @date 2018/8/4 8:02
 * description:
 */
public class Leetcode203_1 {

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead=new ListNode (-1);
		dummyHead.next=head;
		ListNode prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next=prev.next.next;
			} else {
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}
}
