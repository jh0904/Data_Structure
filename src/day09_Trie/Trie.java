package day09_Trie;

import java.util.TreeMap;

/**
 * day09_Trie
 *
 * @author jh
 * @date 2018/8/10 20:11
 * description:定义自己的Trie树，与集合的长的无关，和查找的值的长度有关。
 */
public class Trie {
	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<> ();
		}

		public Node() {
			this (false);
		}
	}

	private Node root;
	private int size;

	public Trie() {
		root = new Node ();
		size = 0;
	}

	public int getSize() {
		return size;
	}

	//向Trie中添加一个新的单词。非递归的方法
	public void add(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length (); i++) {
			char c = word.charAt (i);
			if (cur.next.get (c) == null) {
				cur.next.put (c, new Node ());
			}
			cur = cur.next.get (c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
			size++;
		}
	}

	//查询一个单词
	public boolean contains(String word) {

		Node cur = root;
		for (int i = 0; i < word.length (); i++) {
			char c = word.charAt (i);
			if (cur.next.get (c) == null) {
				return false;
			}
			cur = cur.next.get (c);
		}
		//查找到最后一个节点，看是否有这个单词（pan---> 平底锅 ||||||panda ---->熊猫）
		return cur.isWord;
	}

	//前缀搜索 一个单词也是自己的前缀
	public boolean isPrefix(String prefix){
		Node cur=root;
		for (int i = 0; i < prefix.length (); i++) {
			char c = prefix.charAt (i);
			if (cur.next.get (c) == null) {
				return false;
			}
			cur = cur.next.get (c);
		}
		return true;
	}
}
