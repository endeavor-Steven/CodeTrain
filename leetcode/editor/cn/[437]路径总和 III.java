package leetcode.editor.cn;

//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1381 👎 0

import java.util.Deque;
import java.util.*;

public class PathSumIii{
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        
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
        TreeNode () {}
        TreeNode (int val) {this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int pathSum(TreeNode root, int targetSum) {
        /**
         * DFS
         * 思路解析：
         * 在DFS中每到一个点，以这个点为起点，向下搜搜有多少种路径符合要求（可以理解为DFS嵌套DFS）
         *
         * 定义一个辅助函数，dfs(root,  target), 表示root节点开始向下搜索满足路径和为target的路径。
         * 最所有的点求dfs累加返回结果
         */
        if (root == null) {
            return 0;
        }
        int ans = DFS(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }
    public int DFS(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.val == targetSum)
            ++ans;
        ans += DFS(root.left, targetSum - root.val);
        ans += DFS(root.right, targetSum - root.val);
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}