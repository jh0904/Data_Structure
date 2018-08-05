package day05_BinarySearchTree;

/**
 * day05_BinarySearchTree
 *
 * @author jh
 * @date 2018/8/5 8:38
 * description:实现自己的二分搜索树
 */
public class BST<E extends Comparable<E>> {

	private class Node {

		private E e;
		private Node left, right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		/*if (root == null) {
			root = new Node (e);
			size++;
		} else {
			add (root, e);
		}*/
		root = add (root, e);

	}

	//向以node为根的二分搜索树中插入元素e，递归算法。
	//返回插入新节点后二分搜索树的根
	private Node add(Node node, E e) {
		/*if (e.equals (node.e)) {
			return;
		} else if (e.compareTo (node.e) < 0 && node.left == null) {
			node.left = new Node (e);
			size++;
			return;
		} else if (e.compareTo (node.e) > 0 && node.right == null) {
			node.right=new Node (e);
			size++;
			return;
		}*/
		if (node == null) {
			size++;
			return new Node (e);
		}
		if (e.compareTo (node.e) < 0) {
			node.left = add (node.left, e);
		} else if (e.compareTo (node.e) > 0) {
			node.right = add (node.right, e);
		}
		return node;
	}

	//查看二分搜索树中是否包含元素e,递归算法
	public void contains(E e) {
		contains (root, e);
	}

	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		if (e.compareTo (node.e) == 0) {
			return true;
		} else if (e.compareTo (node.e) < 0) {
			return contains (node.left, e);
		} else {
			return contains (node.right, e);
		}
	}

	// 二分搜索树的前序遍历
	public void preOrder() {
		preOrder (root);
	}

	// 前序遍历以node为根的二分搜索树, 递归算法
	private void preOrder(Node node) {
		if (node == null)
			return;

		System.out.println (node.e);
		preOrder (node.left);
		preOrder (node.right);
	}

	//中序遍历 遍历出的结果就是排序后的结果。
	public void inOrder() {
		inOrder (root);
	}

	private void inOrder(Node node) {
		if(node==null){
			return;
		}

		inOrder (node.left);
		System.out.println (node.e);
		inOrder (node.right);
	}
	//后序遍历
	public void postOrder(){
		postOrder (root);
	}

	private void postOrder(Node root) {
		if(root==null){
			return;
		}
		postOrder (root.left);
		postOrder (root.right);
		System.out.println (root.e);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		generateBSTString (root, 0, res);
		return res.toString ();
	}

	// 生成以node为根节点，深度为depth的描述二叉树的字符串
	private void generateBSTString(Node node, int depth, StringBuilder res) {

		if (node == null) {
			res.append (generateDepthString (depth) + "null\n");
			return;
		}

		res.append (generateDepthString (depth) + node.e + "\n");
		generateBSTString (node.left, depth + 1, res);
		generateBSTString (node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder ();
		for (int i = 0; i < depth; i++)
			res.append ("--");
		return res.toString ();
	}

}