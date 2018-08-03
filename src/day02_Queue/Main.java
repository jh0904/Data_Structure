package day02_Queue;

import java.util.Random;

/**
 * day02_Queue
 *
 * @author jh
 * @date 2018/8/2 16:26
 * description:
 */
public class Main {
	//测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
	public static double testQueue(Queue<Integer> q,int opCount){
		long startTime = System.nanoTime ();
		Random random = new Random ();
		for (int i = 0; i <opCount ; i++) {
				q.enqueue (random.nextInt (Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			q.dequeue ();
		}
		long endTime = System.nanoTime ();
		return (endTime-startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		int opCount=100000;

	/*	ArrayQueue<Integer> arrayQueue = new ArrayQueue<> ();
		double v = testQueue (arrayQueue,opCount);
		System.out.println ("arrayQueue---->"+v);*/


		LoopQueue<Integer> loopQueue = new LoopQueue<> ();
		double v1 = testQueue (loopQueue,opCount);
		System.out.println ("loopQueue---->"+v1);
	}

}
