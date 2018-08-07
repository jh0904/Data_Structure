package day06_SetAndHash;

import day03_linklist.LinkList;

import java.util.LinkedList;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 8:42
 * description:
 */
public class LinkedListSet<E> implements Set<E> {
	private LinkList<E> list;

	public LinkedListSet() {
		list = new LinkList<> ();
	}

	@Override
	public void add(E e) {
		if(!list.contains (e)){
			list.addFirst (e);
		}
	}

	@Override
	public void remove(E e) {
		list.removeElement (e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains (e);
	}

	@Override
	public int getSize() {
		return list.getSize ();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty ();
	}
}
