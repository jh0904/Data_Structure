package day07_PriorityQueue;

import java.util.Random;

/**
 * day07_PriorityQueue
 *
 * @author jh
 * @date 2018/8/8 9:40
 * description:
 */
public class Main {
	public static void main(String[] args) {
		/*int n = 1000000;
		MaxHeap<Integer> maxHeap = new MaxHeap<> ();
		Random random = new Random ();
		for (int i = 0; i < n; i++) {
			maxHeap.add (random.nextInt (Integer.MAX_VALUE));
		}
		int[] arr = new int[n];
		for (int i1 = 0; i1 < n; i1++) {
			arr[i1] = maxHeap.extractMax ();
		}
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException ("error");
			}
		}
		System.out.println ("success");*/

		MaxHeap<Integer> maxHeap = new MaxHeap<> ();
		Random random = new Random ();
		for (int i = 0; i < 13; i++) {
			maxHeap.add (random.nextInt (100));
		}

		Integer replace = maxHeap.replace (2);
		System.out.println (replace);
	}
}
