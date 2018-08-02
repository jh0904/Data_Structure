package day02_Queue;

/**
 * day02_Queue
 *
 * @author jh
 * @date 2018/8/2 9:55
 * description:队列的基本实现
 */
public interface Queue<E> {

	  void enqueue(E e);

	  E dequeue();

	  E getFront();

	  int getSize();

	  boolean isEmpty();
}
