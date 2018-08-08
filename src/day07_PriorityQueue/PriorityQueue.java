package day07_PriorityQueue;

import day02_Queue.Queue;

/**
 * day07_PriorityQueue
 *
 * @author jh
 * @date 2018/8/8 10:18
 * description:
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private MaxHeap<E> maxHeap;

	public PriorityQueue() {
		maxHeap = new MaxHeap<>();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add (e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax ();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax ();
	}

	@Override
	public int getSize() {
		return maxHeap.size ();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty ();
	}
}
