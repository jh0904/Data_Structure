package day10_UnionFind;

/**
 * day10_UnionFind
 *
 * @author jh
 * @date 2018/8/13 21:32
 * description:加入路径压缩方法
 */
public class UnionFind6 implements UF{

	private int[] parent;
	private int[] rank;  //rank[i]表示以i为根的集合所表示的树的层数

	public UnionFind6(int size) {
		parent = new int[size];
		rank = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}


	//使用递归函数
	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException ("p没有找到");
		}
		if (p != parent[p]) {
			parent[p]=find (parent[p]);
		}
		return parent[p];
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find (p) == find (q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find (p);
		int qRoot = find (q);

		if (pRoot == qRoot) {
			return;
		}

		//将rank低的地核合并到rank高的集合上
		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		} else if(rank[pRoot] > rank[qRoot]){
			parent[qRoot] = pRoot;
		}
		else { //rank[pRoot] == rank[qRoot]
			parent[qRoot] = pRoot;
			 rank[pRoot]+=1;
		}

	}
}
