package day06_SetAndHash;

/**
 * day06_SetAndHash
 *
 * @author jh
 * @date 2018/8/7 9:38
 * description:创建映射的接口
 */
public interface Map<K, V> {

	void add(K k, V v);

	V remove(K k);

	boolean contains(K k);

	V get(K k);

	void set(K k, V v);

	int getSize();

	boolean isEmpty();
}
