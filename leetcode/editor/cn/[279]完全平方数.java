package leetcode.editor.cn;

//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1418 👎 0

public class PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        /**
         * 动态规划
         *
         * 思路分析：
         * 寻找一个数的最少需要多少个数的平方来表示，那么搜索区间是[1, sqrt(n)], (sqrt(n) * sqrt(n))的情况就是正好可以开方
         * 假设当前找到的数是i, 那么还要找到 n - i*i  的情况加上 i 的情况
         *
         * 定义：dp[i], 最少需要多少个完全平方数来表示i
         * 状态：dp[i] = min(dp[i], 1 + dp[i - j * j]) (1 <= j <= sqrt(j));
         *      这里的1 + dp[i - j * j]指的应该是 找到i - j^2 的最小平方数组合
         * 边界：dp[0] = 0;
         */
        int[] dp = new int[n + 1]; //定义状态
        for (int i = 1; i <= n; i++) {
            dp[i] = i;  //每次将次数变成最大，即n个1相加。
            for (int j = 1; i - j * j  >= 0; j++) {
                dp[i] = Math.min(dp[i] , 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}