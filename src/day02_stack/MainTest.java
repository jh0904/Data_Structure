package day02_stack;

/**
 * day02_stack
 *
 * @author jh
 * @date 2018/8/2 9:10
 * description:
 */
public class MainTest {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<> ();

		for (int i = 0; i < 5; i++) {
			stack.push (i);
			System.out.println (stack);
		}

		stack.pop ();
		System.out.println (stack);
	}
}
