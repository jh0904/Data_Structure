package day03_linklist;

import day02_Queue.Queue;

/**
 * day03_linklist
 *
 * @author jh
 * @date 2018/8/3 11:00
 * description:实现一个链表的队列,首先创建一个队尾元素tail。
 * tail做对尾
 * head做对首
 */
public class LinkedListQueue<E> implements Queue<E> {

	private class Node {
		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this (e, null);
		}

		public Node() {
			this (null, null);
		}

		@Override
		public String toString() {
			return e.toString ();
		}
	}

	private Node head, tail;
	private int size;

	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void enqueue(E e) {
		if (tail == null) {
			tail = new Node (e);
			head = tail;
		} else {
			tail.next = new Node (e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty ()) {
			throw new IllegalArgumentException ("队列为空");
		}
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		if (head == null) {
			tail = null;
		}
		size--;
		return null;
	}

	@Override
	public E getFront() {
		if (isEmpty ()) {
			throw new IllegalArgumentException ("队列为空");
		}
		return head.e;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		res.append ("Queue: front ");
		Node cur=head;
		while(cur!=null){
			res.append (cur+"->");
			cur=cur.next;
		}
		res.append ("NULL tail");
		return res.toString ();
	}
}