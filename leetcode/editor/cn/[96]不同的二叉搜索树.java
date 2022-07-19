package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1777 👎 0

public class UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        /**
         * 方法1：动态规划
         * 在遍历过程中，不同的元素生成的二叉树由于根不同是肯定不同的。
         * 所以枚举每一个树作为树根的情况
         *
         * 1、
         * G(n): n个节点能形成不同二叉搜索树的个数。  --边界G(0) = 1, G(1) = 1;
         * f(i): 以i为根的二叉搜索树个数
         * 显然G(n) = f(1) + f(2) + f(3) + ... + f(n-1) + f(n)
         * 2、
         * 当根节点是i时，显然左子树节点个数为i-1, 右子树节点个数为n-i.
         * 用上述两个函数表示则为：f(i) = G(i-1) * G (n-i);
         *
         * 1+2可以得到一个公式
         * G(n) = f(1) + f(2) + f(3) + ... + f(n-1) + f(n)
         *      = G(0)*G(n-1) + G(1)*G(n-2) + G(2)*G(n-3) + ... + G(n-2)*G(1) + G(n-1)*G(0)
         *
         */
        int[] G = new int[n + 1];//G(0)  G(n)都是有状态的
        G[0] = 1;
        G[1] = 1;
        for (int len = 2 ; len < n + 1; len++) {//不同长度
            for (int i = 1; i <= len; i++) {//不同根
                G[len] = G[len] + G[i-1] * G[len-i];
            }
        }
        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}