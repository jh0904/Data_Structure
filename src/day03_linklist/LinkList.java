package day03_linklist;

/**
 * day03_linklist
 *
 * @author jh
 * @date 2018/8/3 9:00
 * description:创建自己的链表
 */
public class LinkList<E> {

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

	private Node dummyHead;
	private int size;

	public LinkList() {
		dummyHead = new Node (null, null);
		size = 0;
	}

	//获取链表元素
	public int getSize() {
		return size;
	}

	//链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	//在链表的index位置添加元素（不常用，顺序很重要 ）
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException ("插入失败，位置有误");
		}
		Node prev = dummyHead;//找index前一个元素
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		//Node node = new Node (e);
		//node.next = prev.next;
		//prev.next = node;

		prev.next = new Node (e, prev.next);
		size++;
	}

	//链表头添加元素
	public void addFirst(E e) {
		//Node node=new Node (e);
		//node.next=head;
		//head=node;
		//head = new Node (e, head);
		add (0, e);
	}

	//末添加新元素
	public void addLast(E e) {
		add (size, e);
	}

	//获取链表index位置的元素（不常用，练习）
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException ("获取失败，位置有误");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}

	public E getFirst() {
		return get (0);
	}

	public E getLast() {
		return get (size - 1);
	}

	//更新index位置的元素
	public void set(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException ("设置失败，位置有误");
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}

	//查找链表中是否存在e
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.e.equals (e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	//从链表中删除指定index位置的元素(不常用)
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException ("删除失败，位置有误");
		}
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size--;
		return retNode.e;
	}

	//删除头节点
	public E removeFirst() {
		return remove (0);
	}

	//删除尾节点
	public E removeLast() {
		return remove (size - 1);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		//Node cur=dummyHead.next;
	/*	while(cur!=null){
			res.append (cur+"->");
			cur=cur.next;
		}*/

		for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
			res.append (cur + "->");
		}
		res.append ("NULL");
		return res.toString ();
	}
}
