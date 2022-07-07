package leetcode.editor.cn;
import java.util.*;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 👍 1083 👎 0

public class DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        
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
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        /**
         * 注意分析题目：
         * 最大直径的定义是：任意俩个节点之间距离的最大值
         * 同时要注意：在遍历过程中，路径的长度等于遇到节点数量-1
         * 任何一条路径的长度等于，某个点的左子遍历路径+右子遍历路径
         *
         * 于是问题转换成了。某个点的最大左子深度+最大右子深度， 加上当前节点（+1）为结果
         */
        ans = 1;
        DFS(root);
        return ans - 1;//最大节点数量-1，才等于路径值
    }
    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //注意，这里后序遍历找到的应该是节点的数量
        int deepthL = DFS(root.left);
        int deepthR = DFS(root.right);
        ans = Math.max(ans, deepthL + deepthR + 1); //找到最大节点数量保存进结果集
        return  Math.max(deepthL, deepthR) + 1;//返回的是左子树或者右子树的最大深度，深度要算上根节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}