package leetcode.editor.cn;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-tree/ 
// Related Topics 树 深度优先搜索 二叉树 👍 469 👎 0

public class ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeZuiJinGongGongZuXianLcof().new Solution();
        
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
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * root, p, q三者之间的关系只能是这样子
         * 1、p, q位于root的异侧子树中
         * 2、root = p, q在root的子树中
         * 3、root = q, p在root的子树中
         *
         * 考虑通过递归对二叉树进行先序遍历，当遇到节点p或q时返回。
         * 从底至顶回溯，当节点p, q在节点 root的异侧时，节点 root即为最近公共祖先，则向上返回root 。
         *
         * l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 最近公共祖先
         * l、r 任一为空，说明最近公共祖先位于另一子树或其祖先中
         *
         *
         * 也可以存储父节点的形式来做，使用HashMap存储每个结点的父节点
         */
        if(root == null)
            return null;
        if(root == p || root == q)//根节点递归到了一个目标位置(p或者q)，那么返回回去
            return root;
        // 递归左子树，右子树，寻找p,q先找到谁就返回谁，这里可以看成一个找祖先的过程
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //下面三个判断相当于在逼近pq两点存在的范围
        if(left == null)
            return right;	//左子树一个点都找不到，那么肯定两个目标点都在右侧
        else if(right == null)
            return left;	//右子树一个点都找不到，那么肯定两个目标点都在右侧
        else
            return root;//左右子树的分别含有目标前，此时root就是祖先
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}