package day01_array;

/**
 * day01_array
 *
 * @author jh
 * @date 2018/8/1 8:53
 * description:数组的简单学习
 * 把数据码成一排进行存放。单个数据类型，索引
 * 数组的最大优点：快速查询；“索引最好有语义”
 */
public class Demo1 {
	public static void main(String[] args) {
		/*int[] arr=new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}

		int[] scores=new int[]{100,99,66};

		for (int score : scores) {
			System.out.println (score);
		}*/

		Array<Integer> arr=new Array<> ();

		for (int i = 0; i < 10; i++) {
			arr.addLast (i);
		}

		System.out.println (arr);

		arr.add (1,100);
		System.out.println (arr);

		arr.addFirst (-1);
		System.out.println (arr);

		arr.remove (2);

		System.out.println (arr);

		arr.removeElement (8);

		System.out.println (arr);
		arr.removeFirst ();

		System.out.println (arr);


	}
}
