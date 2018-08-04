package day04_LinkedList;

/**
 * day04_LinkedList
 *
 * @author jh
 * @date 2018/8/4 7:44
 * description:
 */
public class Leetcode203_2 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		head.next = removeElements (head.next, val);
		/*if(head.val==val){
			return head.next;
		}else {
			return head;
		}*/
		return head.val == val ? head.next : head;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 6, 3, 4, 5, 6};
		ListNode head = new ListNode (nums);
		System.out.println (head);

		ListNode res = (new Leetcode203_2 ()).removeElements (head, 6);
		System.out.println (res);

	}
}
