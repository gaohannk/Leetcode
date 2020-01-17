package company.databricks.phone;

/**
 * 所有的input都是int[][] 形式 {{1,3}, {3,5}}...
 * 第一题就是找zero parent和one parent的所有点，分成两个list输出
 * 第二题是找出两个点的common ancestor, 有就输出true 没有false. input: in[][] pairs, int a ,int b.
 * 如果a是b的ancestor，他俩的common ancestor里面没有a.
 * 第三题是找出一个点最远的ancestor. 如果有多个就任意输出一个.
 * 题目一：求有0个父节点和1个父节点的点。输出自己定，需要长这样：[[0,1], [2,3,4]]
 * 题目二：求两个点是否有相同的祖先。祖先不包括input node自己（所以遍历完之后记得除掉自己）。输入(int[][] edges, int x, int y).
 * 题目三：求一个点的最早的祖先。如果这个点没有祖先返回-1. (不在testcase中，但如果有多个最早的祖先，任意返回一个)。输入(int[][] edges, int x)没有写完，讲了思路。
 **/
public class Problem1 {

}
