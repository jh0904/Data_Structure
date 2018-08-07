package day06_SetAndHash;

import java.util.ArrayList;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 8:17
 * description:
 */
public class Test {
	public static void main(String[] args) {
		System.out.println ("傲慢与偏见");
		ArrayList<String> list = new ArrayList<> ();
		boolean b = FileOperation.readFile ("C:\\Users\\jh\\IdeaProjects\\Data_Structure\\src\\day06_SetAndHash\\pride-and-prejudice.txt", list);
		System.out.println ("Total words:" + list.size ()+"--->"+b);

		BSTSet<String> set = new BSTSet<> ();
		for (String s : list) {
			set.add (s);
		}
		System.out.println ("不重复的单词有"+set.getSize ());
	}
}
