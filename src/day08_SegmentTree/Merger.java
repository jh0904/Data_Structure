package day08_SegmentTree;

/**
 * day08_SegmentTree
 *
 * @author jh
 * @date 2018/8/9 10:45
 * description:创建类型，增强线段树的扩展性
 */
public interface Merger<E> {
	E merger(E a, E b);
}
