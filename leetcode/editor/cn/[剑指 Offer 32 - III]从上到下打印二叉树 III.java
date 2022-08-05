package leetcode.editor.cn;
import java.util.*;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 243 👎 0

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        
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
        TreeNode(int x) {this.val = x;}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        q.offer(root);
        int levelNo = 0;
        while (!q.isEmpty()) {
            ++levelNo;
            List<Integer> levelRes = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = q.poll();
                levelRes.add(tmp.val);
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);
            }
            if ((levelNo & 1) == 0) Collections.reverse(levelRes);
            res.add(levelRes);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}