package day10_UnionFind;

/**
 * day10_UnionFind
 *
 * @author jh
 * @date 2018/8/13 20:17
 * description:并查集接口
 */
public interface UF {
	int getSize();
	boolean isConnected(int p, int q);
	void unionElements(int p, int q);

}
