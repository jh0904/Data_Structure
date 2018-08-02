package day02_Queue;

/**
 * day02_Queue
 *
 * @author jh
 * @date 2018/8/2 10:08
 * description:
 */
public class Test {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();
		for (int i = 0; i <10 ; i++) {
			queue.enqueue (i);
			System.out.println (queue);
		}

		queue.dequeue ();

		System.out.println (queue);
	}

}
