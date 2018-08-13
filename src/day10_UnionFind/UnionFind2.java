package day10_UnionFind;

/**
 * day10_UnionFind
 *
 * @author jh
 * @date 2018/8/13 20:52
 * description:第二个版本并查集,由孩子指向父亲的
 */
public class UnionFind2 implements UF {
	private int[] parent;

	public UnionFind2(int size) {
		parent = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException ("p没有找到");
		}
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find (p) == find (q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot=find (p);
		int qRoot=find (q);

		if(pRoot==qRoot){
			return;
		}

		parent[pRoot]=qRoot;
	}
}
