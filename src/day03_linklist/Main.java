package day03_linklist;

/**
 * day03_linklist
 *
 * @author jh
 * @date 2018/8/3 9:44
 * description:
 */
public class Main {
	public static void main(String[] args) {
		LinkList<Integer> l=new LinkList<> ();
		for (int i = 0; i < 5; i++) {
			l.addFirst (i);
			System.out.println (l);
		}
		l.add (2,666);
		System.out.println (l);
		/*l.remove (2);
		System.out.println (l);*/
		/*l.removeFirst ();
		System.out.println (l);*/
		l.removeLast ();
		System.out.println (l);
	}
}
