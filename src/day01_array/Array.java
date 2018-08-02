package day01_array;

/**
 * day01_array
 *
 * @author jh
 * @date 2018/8/1 9:11
 * description:实现自己的数组类
 */
public class Array<E> {

	private E[] data;
	private int size;

	//构造函数，传入数组的容量capacity构造Array
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	//无参函数，设置默认值为10
	public Array() {
		this (10);
	}

	//获取数组容量
	public int getCapacity() {
		return data.length;
	}

	//获取数组中元素的个数
	public int getSize() {
		return size;
	}

	//返回数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	//添加：元素到末尾  O(1)
	public void addLast(E e) {
		add (size, e);
	}

	//添加：向数组头添加元素 O(n)
	public void addFirst(E e) {
		add (0, e);
	}

	//添加：向index位置添加元素e。 O(n/2)=O(n) 添加操作总的来说是O(n) 一般来说是最坏情况
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException ("添加失败，添加位置有误！");
		}
		if (size == data.length) {
			resize (2 * data.length);//ArrayList是1.5倍
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	public void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	//获取指定元素 O(1)
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException ("查找失败，查找位置有误！");
		}
		return data[index];
	}

	//修改元素 O(1)
	public  void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException ("查找失败，查找位置有误！");
		}
		data[index] = e;
	}

	//是否包含e元素 O(n)
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals (e)) {
				return true;
			}
		}
		return false;
	}

	//查找元素，返回索引 O(n)
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals (e)) {
				return i;
			}
		}
		return -1;
	}

	//删除元素 返回删除的元素
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException ("查找失败，查找位置有误！");
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		data[size] = null;  //loitering objects  !=memory leak(内存泄漏)
		if (size == data.length / 4 && data.length != 0) {
			resize (data.length / 2);
		}
		return ret;
	}

	//删除第一个元素返回删除的元素 O(n)
	public E removeFirst() {
		return remove (0);
	}

	//删除最后一个元素返回删除的元素 O(1)
	public E removeLast() {
		return remove (size - 1);
	}

	//删除指定的e元素  removeAllElement  findAll  O(n)
	public void removeElement(E e) {
		//只删除了第一个e
		int index = find (e);
		if (index != -1) {
			remove (index);
		}
	}

	//动态数组

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		res.append (String.format ("Array:size=%d,capacity=%d\n", size, data.length));
		res.append ('[');
		for (int i = 0; i < size; i++) {
			res.append (data[i]);
			if (i != size - 1) {
				res.append (",");
			}
		}
		res.append (']');
		return res.toString ();
	}


	public E getLast(){
		return  get (size-1);
	}

	public E getFirst(){
		return get(0);
	}

}
