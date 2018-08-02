package day02_stack;

/**
 * day02_stack
 *
 * @author jh
 * @date 2018/8/2 8:50
 * description:
 */
public interface Stack<E> {
	void push(E e);

	E pop();

	E peek();

	int getSize();

	boolean isEmpty();
}
