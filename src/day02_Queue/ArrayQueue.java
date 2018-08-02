package day02_Queue;

import day01_array.Array;

/**
 * day02_Queue
 *
 * @author jh
 * @date 2018/8/2 9:57
 * description:
 */
public class ArrayQueue<E> implements Queue {

	private Array<E> array;

	public ArrayQueue(int capacity){
		array=new Array<> (capacity);
	}
	public ArrayQueue(){
		array=new Array<> ();
	}

	@Override
	public void enqueue(Object o) {
		array.addLast ((E) o);
	}

	@Override
	public E dequeue() {
		return array.removeFirst ();
	}

	@Override
	public E getFront() {
		return array.getFirst ();
	}

	@Override
	public int getSize() {
		return array.getSize ();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty ();
	}

	public int getCapacity(){
		return array.getCapacity ();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		res.append ("Queue:");
		res.append ("front [");
		for (int i = 0; i < array.getSize (); i++) {
			res.append (array.get (i));
			if (i != array.getSize () - 1) {
				res.append (",");
			}
		}
		res.append ("] tail");
		return res.toString ();
	}

}
