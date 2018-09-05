package day12_hash;

/**
 * day12_hash
 *
 * @author jh
 * @date 2018/9/5 14:31
 * description:实现leetcode 387.字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class Demo_387 {
	public static void main(String[] args) {
		System.out.println (firstUniqChar ("loveleetcode"));
	}

	public static int firstUniqChar(String s) {
		int[] freq=new int[26];

		for (int i = 0; i < s.length (); i++) {
			freq[s.charAt (i)-'a']++;
		}

		for (int i = 0; i < s.length (); i++) {
			if(freq[s.charAt (i)-'a']==1){
				return i;
			}
		}
		return -1;
	}
}
