package company.amazon.oa;

/**
 *  amazon fresh, 给两个list 然后让你找到第一个list和第二个list的合小于一个目标k的最大值,并且输出index, 如果有tie,则全部输出. 这里如果只用双指针,不用hashmap的话会有三个test case fail, 当时debug了好久才找到原因所在,是因为有可能有重复元素.
 *  比如说第一个L1是[200, 300, 300, 400, 400, 500], L2是[300, 300, 400,500, 500] 目标是700的话, 会少结果.
 */
public class FindEachInTwoListSumLessThanK {
}
