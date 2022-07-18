package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4937 👎 0

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        /**
         * 1、动态规划
         *
         * 两种转移思路
         * 1、前一个值>0，则加到现在，最后返回最大
         * 2、前一个值加进来的和，和当前的值比较大小
         *
         *思路解析，找到每个位置i结尾的最大子数组合，
         * 定义状态：f(i)位置i结尾的最大子数组合，
         * 状态方程：f(i) = max{f(i-1) + nums[i] , nums[i] }
         * 输出：Max(dp[i])
         */

        //1
//        int ans = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i-1] > 0) {
//                nums[i] += nums[i-1];
//                ans = Math.max(ans, nums[i]);
//            }
//        }
//        return ans;

        //2
        int ans = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
                tmp = Math.max(tmp + nums[i], nums[i]);
                ans = Math.max(ans, tmp);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}