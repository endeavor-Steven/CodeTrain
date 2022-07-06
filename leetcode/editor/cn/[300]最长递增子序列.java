package leetcode.editor.cn;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2606 👎 0

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        /**
         * 动态规划
         * 定义：dp[i], 位置0~i的最大自增子序列长度
         * 状态：dp[i] = max(dp[j]) + 1   && dp[j] < dp[i], nums[j] < nums[i]
         *      nums[j], 是nums[0~j]中以j结尾的最长子序列长度
         * 边界：dp[0] = 1
         * 输出：max(dp[])
         */
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) { //每次确定一个右边界
            dp[i] = 1;  //每个点的原始长度就是自己1
            for (int j = 0; j < i; j++) {//然后判断以右边界为尾部的情况
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}