package day06_SetAndHash;

import day05_BinarySearchTree.BST;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 8:13
 * description:基于二分搜索树的集合
 */
public class BSTSet<E extends Comparable<E>>  implements Set<E> {

	private BST<E> bst;

	public BSTSet(){
		bst = new BST<>();
	}

	@Override
	public int getSize(){
		return bst.size();
	}

	@Override
	public boolean isEmpty(){
		return bst.isEmpty();
	}

	@Override
	public void add(E e){
		bst.add(e);
	}

	@Override
	public boolean contains(E e){
		return bst.contains(e);
	}

	@Override
	public void remove(E e){
		bst.remove(e);
	}
}
