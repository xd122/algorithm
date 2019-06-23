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

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class FindDiffBst {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return getBstList(1, n);
    }

    public List<TreeNode> getBstList(int start, int end) {
        List<TreeNode> resultList = new ArrayList<>();
        if (start > end) {
            resultList.add(null);
        }
        for (int i = start; i <= end; i++) {
            // 已当前节点为状态 寻找左右子树
            List<TreeNode> left = getBstList(start, i - 1);
            List<TreeNode> right = getBstList(i + 1, end);
            // 遍历左右子树 串起来
            for (int leftIndex = 0; leftIndex < left.size(); leftIndex++) {
                for (int rightIndex = 0; rightIndex < right.size(); rightIndex++) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = left.get(leftIndex);
                    tmp.right = right.get(rightIndex);
                    resultList.add(tmp);
                }
            }
        }
        return resultList;
    }
}
