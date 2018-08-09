package day08_SegmentTree;

import java.util.Arrays;

/**
 * day08_SegmentTree
 *
 * @author jh
 * @date 2018/8/9 10:28
 * description:构建自己的线段树
 */
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		tree = (E[]) new Object[4 * arr.length];
		buildSegmentTree (0, 0, data.length - 1);
	}

	//treeIndex位置创建表示[l...r]的线段树
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		int leftTreeIndex = leftChild (treeIndex);
		int rightTreeIndex = rightChild (treeIndex);
		//防止r+l大于int
		int mid = l + (r - l) / 2;
		//创建左子树
		buildSegmentTree (leftTreeIndex, l, mid);
		//创建右子树
		buildSegmentTree (rightTreeIndex, mid + 1, r);

		tree[treeIndex] = merger.merger (tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	public int getSize() {
		return data.length;
	}

	public E get(int index) {
		if (index < 0 || index >= data.length) {
			throw new IllegalArgumentException ("Index is Illegal");
		}
		return data[index];
	}

	private int leftChild(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return 2 * index + 2;
	}

	//返回区间 [queryL,queryR]的值
	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length) {
			throw new IllegalArgumentException ("index参数非法");
		}
		return query (0, 0, data.length - 1, queryL, queryR);
	}

	//treeID为根的线段树中[l...r]的范围内，搜索区间 [queryL,queryR]的值
	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}
		int mid = l + (r - l) / 2;
		// treeIndex的节点分为[l...mid]和[mid+1...r]两部分

		int leftTreeIndex = leftChild (treeIndex);
		int rightTreeIndex = rightChild (treeIndex);
		if (queryL >= mid + 1)
			return query (rightTreeIndex, mid + 1, r, queryL, queryR);
		else if (queryR <= mid)
			return query (leftTreeIndex, l, mid, queryL, queryR);

		E leftResult = query (leftTreeIndex, l, mid, queryL, mid);
		E rightResult = query (rightTreeIndex, mid + 1, r, mid + 1, queryR);
		return merger.merger (leftResult, rightResult);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder ();
		res.append ('[');
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null)
				res.append (tree[i]);
			else
				res.append ("null");

			if (i != tree.length - 1)
				res.append (", ");
		}
		res.append (']');
		return res.toString ();
	}
}
