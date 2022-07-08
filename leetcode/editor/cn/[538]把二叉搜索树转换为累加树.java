package leetcode.editor.cn;
import java.util.*;
//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
//sum-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 747 👎 0

public class ConvertBstToGreaterTree{
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        
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
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) {this.val = x;}
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        /**
         * 题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和
         *
         * 思路解析：
         * 首先搜索树的中序遍历是一个递增序列。题目要求是在某个节点的右侧值累加到这上面。、
         * 如果能获得逆序的中序遍历。那么可以在遍历每个节点的同时，获得到这些节点的累加和。
         * 累加和可覆盖到需改变的值上（来到这个节点的时候已经存入了当前节点的值）
         */
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val += sum;
            convertBST(root.left);
        }
        return root;
    }


    /**
     * 直觉做法：
     * 中序遍历获得所有的节点，放到集合中
     * 然后从末端开始累加更新节点。从这一步可以看出，使用栈作为存储可以比较方便的取到末端
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}