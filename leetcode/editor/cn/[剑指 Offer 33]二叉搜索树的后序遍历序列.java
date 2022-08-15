package leetcode.editor.cn;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 574 👎 0

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *          5
     *      2        8
     *   1     3   7     9
     *  inorder 1, 2, 3, 5, 7, 8, 9
     *  pre     5, 2, 1, 3, 8, 7, 9
     *  post    1, 3, 2, 7, 9, 8, 5
     *
     *  法一：递归法
     *      1.划分左右子树
     *          二叉搜索树的特质就是，左子树的值小于根，右子树的值大于根，
     *          那就意味着后序遍历序列中，从左往右遍历，第一个大于末位点的值，就是右子树的开始，由此可以划分左右子树区间。
     *          然后递归处理左右子树
     *      2.判断搜索树
     *          左子区间的所有值是小于当前根节点的，右子区间的所有值是大于当前节点的
     *
     *  这个题还有一个很秀的解法，看不懂下次一定
     */
    public boolean verifyPostorder(int[] postorder) {
        return classify(postorder, 0, postorder.length - 1);
    }
    public boolean classify(int[] postorder, int left, int right) {
        //left是当前子区间的最左侧,right是当前子区间的最右侧也是子树树根
        if (left >= right)  return true;
        int index = left;//先遍历左子区间，判断 左子树 < 树根值，停止的位置应该是右子区间的头部
        while (postorder[index] < postorder[right]) ++index;
        int gap = index;
        while (postorder[index] > postorder[right]) ++index;
        return (index == right) &&
                classify(postorder, left, gap - 1) &&
                classify(postorder, gap, right - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}