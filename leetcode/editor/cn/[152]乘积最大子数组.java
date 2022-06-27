package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 👍 1703 👎 0

public class MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        /**
         * 动态规划
         * dp[i], 每个位置的最大子乘积
         * dp[0] = nums[0] ;
         * 状态转移这个地方要注意，以为存在负号的情况
         * 1、如果当前位置是一个负号，那么我们希望以他前一个位置结尾的某个段的积也是个负数，为的是负负得正。且希望这个积尽可能负得更多
         * 2、如果当前位置是一个正数，那么我们希望以他前一个位置结尾得某个段得积也是个正数，并希望他尽可能得大。
         * 基于上述讨论，我们额外维护一个fmin(i),表示以i个元素结尾得乘积最小字数组得乘积
         * fmax(i) = max(fmax(i-1) x ai, fmin(i-1) x ai, ai)
         * fmin(i) = mix(fmax(i-1) x ai, fmin(i-1) x ai, ai)
         */
        int len = nums.length;
        int fmax = nums[0], fmin = nums[0], ans = fmax;
        for (int i = 1; i < len; i++) {
            int max = fmax, min = fmin;
            //注意这个地方的max和min的参数列表都只能是两个
            fmax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            fmin = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            ans = Math.max(ans, fmax);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}