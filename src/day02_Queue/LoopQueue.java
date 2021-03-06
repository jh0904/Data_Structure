package day02_Queue;

import java.util.Arrays;

/**
 * day02_Queue
 *
 * @author jh
 * @date 2018/8/2 15:08
 * description:
 */
public class LoopQueue<E> implements Queue {

	private E[] data;
	private int front, tail;
	private int size;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}

	public LoopQueue() {
		this (10);
	}

	public int getCapacity() {
		return data.length - 1;
	}

	@Override
	public void enqueue(Object e) {
		if ((tail + 1) % data.length == front) {
			resize (getCapacity () * 2);
		}
		data[tail] = (E) e;
		tail = (tail + 1) % data.length;
		size++;
	}

	@Override
	public E dequeue() {
		if (isEmpty ()) {
			throw new IllegalArgumentException ("队列为空，无法取出数据!");
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if (size == getCapacity () / 4) {
			resize (getCapacity () / 2);
		}
		return ret;
	}

	@Override
	public E getFront() {
		if (isEmpty ()) {
			throw new IllegalArgumentException ("队列为空，无法取出数据!");
		}
		return data[front];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity + 1];

		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		res.append (String.format ("LoopQueue:size=%d,capacity=%d\n", size, getCapacity ()));
		res.append ("front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append (data[i]);
			if ((i + 1) % data.length != tail) {
				res.append (", ");
			}
		}
		res.append ("] tail");
		return res.toString ();
	}
}
