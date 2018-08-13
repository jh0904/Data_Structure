package day10_UnionFind;

/**
 * day10_UnionFind
 *
 * @author jh
 * @date 2018/8/13 20:24
 * description:第一版的并查集
 */
public class UnionFind1 implements UF {
	private int[] id;

	public UnionFind1(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}

	//查找元素p对应的集合编号
	private int find(int p) {
		if (p < 0 || p >= id.length) {
			throw new IllegalArgumentException ("p没有找到");
		}
		return id[p];
	}

	//查看元素p与元素q是否所属一个集合
	@Override
	public boolean isConnected(int p, int q) {
		return find (p)==find (q);
	}

	//将两个元素合并  复杂度：O(n)
	@Override
	public void unionElements(int p, int q) {
		int pID = find (p);
		int qID = find (q);
		if(pID==qID){
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if(id[i]==pID){
				id[i]=qID;
			}
		}
	}
}
