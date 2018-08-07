package day06_SetAndHash;

import day05_BinarySearchTree.BST;

import java.time.temporal.ValueRange;
import java.util.ArrayList;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 10:11
 * description:
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	private class Node{
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value){
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BSTMap() {
		root = null;
		size = 0;
	}

	@Override
	public void add(K k, V v) {
		root = add(root, k, v);
	}

	//向以node为根的二分搜索树中插入元素e，递归算法。
	//返回插入新节点后二分搜索树的根
	private Node add(Node node, K k, V v) {
		if(node == null){
			size ++;
			return new Node(k, v);
		}
		if(k.compareTo(node.key) < 0){
			node.left = add(node.left, k, v);
		} else if (k.compareTo (node.key) > 0) {
			node.right = add (node.right, k, v);
		} else {  //k.compareTo(node.key)==0
			node.value = v;
		}
		return node;
	}

	private Node getNode(Node node, K key) {
		if(node == null)
			return null;

		if(key.equals(node.key))
			return node;
		else if(key.compareTo(node.key) < 0)
			return getNode(node.left, key);
		else // if(key.compareTo(node.key) > 0)
			return getNode(node.right, key);
	}

	@Override
	public V remove(K k) {
		Node node = getNode (root, k);
		if(node!=null){
			root=remove (root,k);
			return node.value;
		}
		return null;
	}

	// 返回以node为根的二分搜索树的最小值所在的节点
	private Node minimum(Node node){
		if(node.left == null)
			return node;
		return minimum(node.left);
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node){

		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}

		node.left = removeMin(node.left);
		return node;
	}

	//递归算法,删除以root为根的e元素节点.
	private Node remove(Node node, K key) {
		if(node==null){
			return null;
		}
		if(key.compareTo (node.key)<0){
			remove (node.left,key);
			return node;
		}else if(key.compareTo (node.key)>0){
			remove (node.right,key);
			return node;
		}else{
			//e.compareTo(node.e)==0
			//待删除节点左子树为空
			if(node.left==null){
				Node right = node.right;
				node.right=null;
				size--;
				return right;
			}
			//待删除节点右子树为空
			if(node.right==null){
				Node leftNode = node.left;
				node.left=null;
				size--;
				return leftNode;
			}

			//待删除节点左右都不为空的情况
			//找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
			//用这个节点顶替待删除节点的位置
			Node successor=minimum (node.right);
			successor.right=removeMin (node.right);
			//size++;
			successor.left=node.left;
			node.left=node.right=null;
			//size--;
			return successor;
		}
	}
	@Override
	public boolean contains(K k) {
		return getNode (root, k) != null;
	}

	@Override
	public V get(K k) {
		Node node = getNode (root, k);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K k, V v) {
		Node node = getNode (root, k);
		if (node == null) {
			throw new IllegalArgumentException (k + "不存在");
		}
		node.value = v;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	public static void main(String[] args){

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readFile("C:\\Users\\jh\\IdeaProjects\\Data_Structure\\src\\day06_SetAndHash\\pride-and-prejudice.txt", words)) {
			System.out.println("Total words: " + words.size());

			BSTMap<String, Integer> map = new BSTMap<>();
			for (String word : words) {
				if (map.contains(word))
					map.set(word, map.get(word) + 1);
				else
					map.add(word, 1);
			}

			System.out.println("Total different words: " + map.getSize());
			System.out.println("Frequency of PRIDE: " + map.get("pride"));
			System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
		}

		System.out.println();
	}
}
