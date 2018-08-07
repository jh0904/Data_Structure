package day06_SetAndHash;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 8:11
 * description:
 */
public interface Set<E> {
	void add(E e);
	void remove(E e);
	boolean contains(E e);
	int getSize();
	boolean isEmpty();
}
