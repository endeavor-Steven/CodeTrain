package leetcode.editor.cn;
import java.util.*;
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 606 👎 0

public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**
         * 思路流程：
         *      若树 B是树 A的子结构，则子结构的根节点可能为树 A的任意一个节点。
         *      因此，判断树 B否是树 A的子结构，需完成以下两步工作：
         *          1.先序遍历A中的所有节点
         *          2.遍历过程中A的每一个节点nA都判断一下是否包含B
         * 怎么判断nA是否包含B呢
         *      目的是匹配到nA.val = B.val
         *      然后二者保持同步递归，如果是子结构那么就可以同时走下去
         *      当B递归到叶子节点以外的时候那么就可以认为是成功了
         *
         */
        if (A == null || B == null)//题目约定空树不是子树
            return false;
        //先序递归遍历，分别去对nA判断是否包含B
        return match(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean match(TreeNode A, TreeNode B) {//用来匹配AB两棵树是否一致
        if(B == null)   return true;
        if(A == null || A.val != B.val) return false;
        return match(A.left, B.left) && match(A.right, B.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}