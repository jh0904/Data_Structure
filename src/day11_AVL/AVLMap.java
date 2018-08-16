package day11_AVL;

import day06_SetAndHash.Map;

/**
 * day11_AVL
 *
 * @author jh
 * @date 2018/8/16 12:09
 * description:
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {

	private AVLTree<K,V> avl;

	public AVLMap() {
		avl=new AVLTree<> ();
	}

	@Override
	public void add(K k, V v) {
		avl.add (k,v);
	}

	@Override
	public V remove(K k) {
		return avl.remove (k);
	}

	@Override
	public boolean contains(K k) {
		return avl.contains (k);
	}

	@Override
	public V get(K k) {
		return avl.get (k);
	}

	@Override
	public void set(K k, V v) {
		avl.set (k,v);
	}

	@Override
	public int getSize() {
		return avl.getSize ();
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty ();
	}
}
