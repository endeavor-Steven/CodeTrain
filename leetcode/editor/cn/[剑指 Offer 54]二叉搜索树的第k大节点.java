package leetcode.editor.cn;

//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 327 👎 0

import java.util.ArrayList;
import java.util.List;

public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x){this.val = x;}
    }
    int count, ans;
    public int kthLargest(TreeNode root, int k) {
        /**
         * 中序+倒数打印虽然也可以，但是效率差很多
         * 可以倒序遍历中序，然后打印第k个元素
         */
        this.count = k;
        reverseInOrder(root);
        return ans;
    }
    public void reverseInOrder(TreeNode root) {
        if (root != null) {
            reverseInOrder(root.right);
            if (count == 0) return;
            if (--count == 0)
                ans = root.val;
            reverseInOrder(root.left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}