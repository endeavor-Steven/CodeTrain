package leetcode.editor.cn;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1942 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution {
    /**
     *方法1：递归
     * 两组指针同步遍历，从根出发，镜像遍历左右子树
     * 每到一个点判断，是否相等。如此递归
     * 注意在判断的时候的集中判断情况
     *
     */
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//
//        return check(root, root);
//    }
//    public static boolean check(TreeNode left, TreeNode right) {
//         //注意这里两个判断顺序不对的话得到的结果可能有问题
//        if (left == null && right == null)
//            return true;
//        if (left == null || right == null)
//            return false;
//        return (left.val == right.val) &&
//                (check(left.left, right.right)) &&
//                (check(left.right, right.left));
//    }

    /**
     * 方法2:迭代
     * 使用层次遍历
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public static boolean check(TreeNode left, TreeNode right) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(left);
        q.offer(right);
        while (!q.isEmpty()) {
            left = q.poll();
            right = q.poll();
            if (left == null && right == null) {//注意这里是找到各种不对的情况
                continue;
            }
            if (left == null ||right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}