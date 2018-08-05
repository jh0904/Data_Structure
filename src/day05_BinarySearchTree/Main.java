package day05_BinarySearchTree;

public class Main {

	public static void main(String[] args) {

		BST<Integer> bst = new BST<> ();
		int[] nums = {5, 3, 6, 8, 4, 2};
		for (int num : nums) {
			bst.add (num);
		}
		/////////////////
		//      5      //
		//    /   \    //
		//   3    6    //
		//  / \    \   //
		// 2  4     8  //
		/////////////////
		/*bst.preOrder ();
		System.out.println ("----------------------");*/
		/*bst.inOrder ();
		System.out.println ("----------------------");
		bst.postOrder ();
		System.out.println ("----------------------");*/
		//bst.preOrderNR ();
		//System.out.println(bst);
		//bst.levelOrder ();
		/*
		* 查找最大的元素就是一直去寻找他的右节点,知道最后一个右节点的右子树为null时,说明找到最大值,然后返回当前节点.
		* 删除就是在找到节点为null1的时候,执行删除操作,然后在返回这个元素.
		*
		* */
		bst.minimum ();
		bst.maximum ();
	}
}