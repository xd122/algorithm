package dp;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-23
 * Package : dp
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class FindNumsTree {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int length = 2; length <= n; length++) {
            for (int left = 1; left <= length; left++) {
                // 状态转移公式
                /**
                 * 以当前节点为根节点的情形有多少种？=》(F[left] * F[right])
                 * left = i-1; right = n -i;
                 */
                dp[length] += dp[left - 1] * dp[length - left];
            }
        }
        return dp[n];
    }
}
