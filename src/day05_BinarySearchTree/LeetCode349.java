package day05_BinarySearchTree;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * day05_BinarySearchTree
 *
 * @author jh
 * @date 2018/8/5 11:19
 * description:
 */
public class LeetCode349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<> ();
		for (int i : nums1) {
			set.add (i);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : nums2) {
			if(set.contains (i)){
				list.add (i);
				set.remove (i);
			}
		}
		int[] res=new int[list.size ()];
		for (int i = 0; i < list.size (); i++) {
			res[i]=list.get(i);
		}
		return res;
	}
}
