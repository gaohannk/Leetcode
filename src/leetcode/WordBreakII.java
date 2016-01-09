package leetcode;
/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
/*这道题不同于上一题，需要我们得到所有能切分的解。这道题难度很大，我们需要采用dp + dfs的方式求解，首先根据dp得到该字符串能否被切分，同时在dp的过程中记录属于字典的子串信息，供后续dfs使用。

首先我们使用dp[i][j]表示起始索引为i，长度为j的子串能否被切分，它有三种状态:

dp[i][j] = true && dp[i][j] in dict，这种情况是这个子串直接在字典中
dp[i][j] = true && dp[i][j] not in dict，这种情况是这个子串不在字典中，但是它能切分成更小的子串，而这些子串在字典中
dp[i][j] = false，子串不能被切分
根据题意，我们需要求出所有切分的解，所以在进行dp的时候需要处理1和2这两种情况，因为对于2来说，dp[i][j]是要继续被切分的，也就是说我们只需要关注第1种情况的子串。

当dp完成之后，我们就需要使用dfs来得到整个的解。在dp[i][j] = 1的情况下面，我们只需要dfs递归处理后面i + j开始的子串就可以了。
 */
public class WordBreakII {

}
