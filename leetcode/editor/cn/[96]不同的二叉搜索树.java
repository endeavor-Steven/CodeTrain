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
         * 在遍历过程中，不同的元素生成的二叉树由于跟不同是肯定不同的
         *
         * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
         * 边界G(0) = 1, G(1) = 1;
         * F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数
         * F(i, n) = G(i-1) * G(n-i);  i点为根的树量 = 序列中左边能构成的树  * 序列中右边能构成的树
         * 从1~n枚举一次
         * 不同的二叉搜索树的总数 G(n)，是对遍历所有i(1≤i≤n)的F(i,n) 之和。
         */
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int len = 2 ; len <= n; len++) {//不同长度
            for (int i = 1; i <= len; i++) {//不同根
                G[len] = G[len] + G[i-1] * G[len-i];
            }
        }
        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}