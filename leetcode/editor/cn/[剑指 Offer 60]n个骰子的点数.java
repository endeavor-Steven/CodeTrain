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
    /**
     * 动态规划
     * 思路整理：
     *      1.某一个点数出现的概率， p(x) 是 x出现的次数 / 所有点数出现的字数
     *      2.投n个骰子，所有点数出现的次数为pow(6, n)
     *      目的: 是计算投掷完n枚骰子后 每个点数出现的次数，这样子除以2就可以了
     *
     * 算法分析：
     *      在分析dp问题的时候，记得从最后一个阶段的分析入手，因为所有的问题多可以被拆分
     *      在本题中的最后一个阶段应该是，投出n个骰子后，所有的点数出现的次数
     *      然后尝试定义状态，dp[][]
     *          一维来标识阶段，也就是投完了几枚骰子
     *          二维来标识投完这些骰子后，可能出现的点数
     *          dp的值表示，该阶段各个点出现的次数
     *          即，dp[i][j] = x, 投完了i枚骰子后点数j出现了x次
     *       然后尝试定义状态的转移
     *          分析最后一个状态时怎么得到的，
     *          因为一枚骰子的点数范围是从1-6
     *          投完第n枚骰子后点数j出现的次数，应该是投完第n-1枚骰子后点数+1，+2...+6得到的
     *          即， Σ dp[n-1][j-i] (1 <= i <= 6)
     *       最后再讨论初始化的边界
     *          只能知道第一个枚骰子的六个点出现次数都是1
     *          即，dp[1][i] = 1 (1 <= i <= 6)
     *
     * dp要素
     *      状态定义：dp[i][j]，投掷完第i个骰子后，点数j出现的次数
     *      状态转移：dp[n][j] = Σ dp[n-1][j-i] (1 <= i <= 6)
     *      边界值：dp[1][i] = i, 1 <= i <= 6
     */
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for(int i = 2; i <= n; i++)                     //枚举投n个骰子，也就是n个阶段
            for(int j = i; j <= 6 * i; j++)             //每个阶段会出现的点数都是上一个阶段最大点数+1开始到阶数的六倍
                for(int k = 1; k <= 6 && k <= j; k++)   //每个阶段投下后，会出现6个新的点
                    dp[i][j] += dp[i-1][j - k];

        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)//投了n枚，最小的值是n个1，最大的是n个6
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}