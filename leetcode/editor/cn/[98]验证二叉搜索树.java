package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1609 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        
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
     * 方法一：递归判断
     * 思路：
     * 1、如果二叉树的左子树不空，则左子树所有结点的值小于根节点的值
     * 2、如果二叉树的右子树不空，则右子树所有结点的值大于个节点的值
     * 此处可以设计一个范围区间用来比对左右子树的值
     * 情况一，则把上界改为根值
     * 情况二，则把下届改为根值
     */
//    public boolean isValidBST(TreeNode root) {
//        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//    public static boolean check(TreeNode root, Long smaller, Long bigger) {
//        if (root == null)
//            return true;
//        if (root.val <= smaller || root.val >= bigger)
//            return false;
//        return check(root.left, smaller, (long)root.val) && check(root.right, (long) root.val, bigger);
//    }


    /**
     * 方法二：
     * 非递归的中序遍历(递增序列)+搜索
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Deque<TreeNode> stack = new LinkedList<>();
        double last = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= last)
                return false;
            last = root.val;
            root = root.right;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}