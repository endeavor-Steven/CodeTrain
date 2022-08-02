package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 869 👎 0

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int x) {
            this.val = x;
        }
        TreeNode(int x, TreeNode l,TreeNode r){
            this.val = x;
            this.left = l;
            this.right = r;
        }

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        root = build(map, preorder,  0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
    public TreeNode build (Map<Integer, Integer> map, int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft <= pRight) { //这些地方要仔细
            int rootValue = preorder[pLeft];
            int inorderRootIndex = map.get(rootValue);
            int len = inorderRootIndex - iLeft;
            TreeNode root = new TreeNode(rootValue);
            root.left = build(map, preorder, pLeft + 1, pLeft + len, inorder, iLeft, inorderRootIndex - 1);
            root.right = build(map, preorder, pLeft + len + 1, pRight, inorder, inorderRootIndex+1, iRight);
            return root;
        } else {
            return null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}