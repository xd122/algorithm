package tree;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-07-01
 * Package : tree
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 利用栈和队列 loop 是这一层节点的个数
public class FromLastOutputTreeNode {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<List<Integer>> tmpStack = new Stack<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        tmpQueue.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        tmpStack.push(rootList);
        while (!tmpQueue.isEmpty()) {
            int loop = tmpQueue.size();
            List<Integer> tmpList = new ArrayList<>();
            while (loop > 0) {
                root = tmpQueue.poll();
                if (root.left != null) {
                    tmpList.add(root.left.val);
                    tmpQueue.add(root.left);
                }
                if (root.right != null) {
                    tmpList.add(root.right.val);
                    tmpQueue.add(root.right);
                }
                loop--;
            }
            if (tmpList != null && tmpList.size() > 0) {
                tmpStack.push(tmpList);
            }
        }
        while (!tmpStack.isEmpty()) {
            resultList.add(tmpStack.pop());
        }
        return resultList;
    }
}
