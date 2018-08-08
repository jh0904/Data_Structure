package day07_PriorityQueue;

import day01_array.Array;

/**
 * day07_PriorityQueue
 *
 * @author jh
 * @date 2018/8/8 8:59
 * description:
 */
public class MaxHeap<E extends Comparable<E>> {
	private Array<E> data;

	public MaxHeap(int capacity) {
		data = new Array<> (capacity);
	}

	public MaxHeap() {
		data = new Array<> ();
	}

	//返回堆中的元素个数
	public int size() {
		return data.getSize ();
	}

	//是否为空
	public boolean isEmpty() {
		return data.isEmpty ();
	}

	//返回完全二叉树的数组表示中，一个索引的父亲节点的索引
	public int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException ("首元素没有头节点");
		}
		return (index - 1) / 2;
	}

	//返回完全二叉树的表示，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	//返回右孩子节点的索引
	private int rightChild(int index) {
		return (index + 1) * 2;
	}

	//添加元素
	public void add(E e) {
		data.addLast (e);
		siftUp (data.getSize () - 1);
	}

	private void siftUp(int k) {
		while (k > 0 && data.get (parent (k)).compareTo (data.get (k)) < 0) {
			data.swap (k, parent (k));
			k = parent (k);
		}
	}

	//看一下堆中最大元素
	public E findMax() {
		if (data.getSize () == 0) {
			throw new IllegalArgumentException ("堆为空");
		}
		return data.get (0);
	}

	//取出堆中最大元素
	public E extractMax() {
		E ret = findMax ();
		data.swap (0, data.getSize () - 1);
		data.removeLast ();
		siftDown (0);
		return ret;
	}

	private void siftDown(int k) {
		while (leftChild (k) < data.getSize ()) {
			int j = leftChild (k);
			if (j + 1 < data.getSize () && data.get (j + 1).compareTo (data.get (j)) > 0) {
				j=rightChild (k);
			}

			if(data.get (k).compareTo (data.get (j))>=0){
				break;
			}

			data.swap (k,j);
			k=j;
		}
	}
	// 取出堆中的最大元素，并且替换成元素e
	public E replace(E e){

		E ret = findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}
}
