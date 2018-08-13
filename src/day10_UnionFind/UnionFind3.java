package day10_UnionFind;

/**
 * day10_UnionFind
 *
 * @author jh
 * @date 2018/8/13 21:19
 * description:第三版并查集
 */
public class UnionFind3 implements UF {
	private int[] parent;
	private int[] sz;

	public UnionFind3(int size) {
		parent = new int[size];
		sz = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
			sz[i] = 1;
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
		int pRoot = find (p);
		int qRoot = find (q);

		if (pRoot == qRoot) {
			return;
		}

		if (sz[pRoot] < sz[qRoot]) {
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else { //sz[pRoot] >= sz[qRoot]
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}

	}

}
