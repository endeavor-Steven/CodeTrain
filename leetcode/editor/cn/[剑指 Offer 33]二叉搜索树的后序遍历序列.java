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
    public boolean verifyPostorder(int[] postorder) {
        /**
         *          5
         *      2        8
         *   1     3   7     9
         *  inorder 1, 2, 3, 5, 7, 8, 9
         *  pre     5, 2, 1, 3, 8, 7, 9
         *  post    1, 3, 2, 7, 9, 8, 5
         *
         *  法一：递归法
         *  二叉搜索树的特质就是，左子树的值小于根，右子树的值大于根
         *  根据后序遍历的特点，最后一的点树的根，从左往右遍历找到的第一个大于根的值就可以划分出左右子树了。
         *  然后判断左右区间是否满足这个二叉树的特质，取一个遍历符从当前区间的左边接力一次遍历到根的前方，就没问题。
         *  递归判断
         *
         *  这个题还有一个很秀的解法，看不懂下次一定
         */
        return classify(postorder, 0, postorder.length - 1);
    }
    public boolean classify(int[] postorder, int left, int right) {
        //left是当前子区间的最左侧,right是当前子区间的最右侧也是子树树根
        if (left >= right)  return true;
        int index = left;
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