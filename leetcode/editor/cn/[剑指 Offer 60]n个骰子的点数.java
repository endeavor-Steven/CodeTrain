package leetcode.editor.cn;

//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 👍 464 👎 0

public class NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        /**
         * dp
         * 某一个点数出现的概率， px = x出现的次数 / 所有点数出现的字数
         * 目的是投掷完n枚骰子后每个点数出现的次数
         *
         * 此处做一个笔记：在分析dp问题的时候，记得从最后一个阶段的分析入手，因为所有的问题多可以被拆分
         * 那么在本题中的最后一个阶段应该是，投出第n个骰子时所有点数的状态
         * 然后开始分析dp的几个要素
         *  状态定义：dp[i][j]，投掷完第i个骰子后，点数j出现的次数
         *  状态转移：dp[n][j] = dp[n-1][j-i], 1 <= i <= 6
         *  边界值：dp[1][i] = i, 1 <= i <= 6
         */
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = i; j <= 6 * i; j++)
                for(int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i-1][j - k];

        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}