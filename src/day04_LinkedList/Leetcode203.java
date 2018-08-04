package day04_LinkedList;

/**
 * day04_LinkedList
 *
 * @author jh
 * @date 2018/8/4 7:44
 * description:
 */
public class Leetcode203 {
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head=head.next;
		}
		if (head == null) {
			return head;
		}
		ListNode prev = head;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next=prev.next.next;
			} else {
				prev = prev.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nums={1,2,6,3,4,5,6};
		ListNode head = new ListNode (nums);
		System.out.println (head);

		ListNode res = (new Leetcode203 ()).removeElements (head, 6);
		System.out.println (res);

	}
}
