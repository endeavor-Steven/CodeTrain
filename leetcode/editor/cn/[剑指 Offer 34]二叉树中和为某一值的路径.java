package leetcode.editor.cn;
import java.util.*;
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 363 👎 0

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        
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
        TreeNode left, right;
        TreeNode(int x){this.val = x;}
    }

    /**
     * 递归法
     * 记录到叶子点的累加和
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null)
            return ans;
        DFS(root, target);
        return ans;
    }
    public void DFS(TreeNode root, int target) {
        if (root != null) {
            comb.add(root.val);
            target -= root.val;
            if (0 == target && root.left == null && root.right == null)
                ans.add(new ArrayList(comb));
            DFS(root.left, target);
            DFS(root.right, target);
            comb.remove(comb.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}