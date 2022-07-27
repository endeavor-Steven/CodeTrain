package leetcode.editor.cn;

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1355 👎 0

public class HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        
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
    public int rob(TreeNode root) {
        /**
         * 动态规划
         * 最优子结构 Max(爷爷节点偷的钱+四个孙子投的钱, 两个儿子投的钱)
         * 重复问题：爷爷节点偷钱的时候，其实也想到过四个孙子可以偷多少， 以及两个儿子可以偷多少
         *      解决方法，在数组结构中可以使用数组存储记忆，但是在树形结构里没办法，那么采用HashMap存储(Node, robMoney)
         *      可以进一步优化这个重复子问题
         * 优化：
         *      每个节点的状态可以被定义为偷或者不偷，且相邻节点不能都偷
         *      换句话说，一个节点偷则孩子节点不能偷；一个节点不偷则孩子节点看情况偷只要钱最多就行
         *
         *      定义：dp[2], 0不偷，1偷
         *      转移：当前节点不偷root[0] = max(root.left[1], root.left[0]) + max(root.right[0], root.right[1])
         *           当前节点要偷root[1] = root.left[0] + root.right[0] + root.val
         */
        int[] ans = robed(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] robed (TreeNode root) {
        int[] dp = new int[2];
        if (root == null)   return dp;
        int[] left =robed(root.left);
        int[] right =robed(root.right);
        //后序遍历，从叶子方向往上偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}