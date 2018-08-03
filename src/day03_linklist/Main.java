package day03_linklist;

import day02_Queue.LoopQueue;
import day02_stack.ArrayStack;

import java.util.Random;

/**
 * day03_linklist
 *
 * @author jh
 * @date 2018/8/3 9:44
 * description:
 */
public class Main {
	public static void main(String[] args) {
		/*LinkList<Integer> l=new LinkList<> ();
		for (int i = 0; i < 5; i++) {
			l.addFirst (i);
			System.out.println (l);
		}
		l.add (2,666);
		System.out.println (l);
		l.remove (2);
		System.out.println (l);
		l.removeFirst ();
		System.out.println (l);
		l.removeLast ();
		System.out.println (l);*/

		//测试链表写的栈
	/*	LinkedListStack<Integer> stack = new LinkedListStack<> ();

		for (int i = 0; i < 5; i++) {
			stack.push (i);
			System.out.println (stack);
		}

		stack.pop ();
		System.out.println (stack);
*/

		int opCount = 100000;

		LinkedListQueue<Integer> queue = new LinkedListQueue<> ();
		/*double v1 = day02_Queue.Main.testQueue (queue, opCount);
		System.out.println ("LinkedListQueue---->" + v1);*/
		queue.enqueue (1);
		queue.enqueue (2);
		queue.enqueue (3);
		System.out.println (queue);
		queue.dequeue ();
		System.out.println (queue);
		/*LoopQueue<Integer> queue1 = new LoopQueue<> ();
		double v2 = day02_Queue.Main.testQueue (queue1, opCount);
		System.out.println ("LoopQueue---->" + v2);*/
	}
}
