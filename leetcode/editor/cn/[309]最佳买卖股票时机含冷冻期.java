package leetcode.editor.cn;

//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1249 👎 0

public class BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 动态规划
         * 思路变化：卖股票是正收益，买股票是负收益。
         * 定义：dp[i], 第i天结束的累计最大收益，
         *      由于同一时间只能持有一只股票， 且卖出股票后有冷静期，所以状态会有三种：
         *          dp[i][0],目前持有一只股票，最大收益为dp[i][0]
         *          dp[i][1],目前没有股票，处于冷静期，
         *          dp[i][2]，目前没有股票，不处于冷静期
         *  转移：
         *      dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i]) ； ；
         *             当前持有股票， 如果是i-1天买的那直接对应状态；如果是i天买的那么i-1天不能处于冷静期同时加上负收益
         *      dp[i][1] = dp[i-1][0] + prices[i]
         *              未持有股票且处于冷静期，意味着i-1天持有股票，则加上当前的收益
         *      dp[i][2] = max(dp[i-1][1], dp[i-1][2])
         *              不持有股票且不处于冷静期，意味着i-1天就没有股票了
         *  返回：
         *      max(dp[n][1], dp[n][2])
         *          最后一天还没卖就没啥意义了
         *  边界：
         *      dp[0][0] = -prices[0]
         *      dp[0][1] = 0
         *      dp[0][2] = 0
         */
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;   //其实这两行也可以不写，因为默认就是0
        dp[0][2] = 0;   //放一起对比
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}