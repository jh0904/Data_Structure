package day03_linklist;

import day02_stack.Stack;

/**
 * day03_linklist
 *
 * @author jh
 * @date 2018/8/3 10:47
 * description:实现一个链表栈
 */
public class LinkedListStack<E> implements Stack<E> {
	private LinkList<E> list;

	public LinkedListStack() {
		list = new LinkList<> ();
	}

	@Override
	public void push(E e) {
		list.addFirst (e);
	}

	@Override
	public E pop() {
		return list.removeFirst ();
	}

	@Override
	public E peek() {
		return list.getFirst ();
	}

	@Override
	public int getSize() {
		return list.getSize ();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty ();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();

		res.append ("Stack: top  ");
		res.append (list);
		return res.toString ();
	}
}
