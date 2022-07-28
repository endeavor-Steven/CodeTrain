package leetcode.editor.cn;
import java.util.*;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1373 👎 0

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        /**
         * 动态规划
         *
         * 题目理解:
         * 判断是否可以从数组中选出一些数字，等于整个数组总和的一半
         *
         * 有几个异常情况需要进行判断
         * 1.nums.length < 2， 则无法分割
         * 2.sum(nums) % 2 == 1, 奇数时, 无法分割
         *   sum(nums) % 2 == 0, 偶数时, 目标判断是 target = sum / 2,
         * 3.maxNum, 最大元素如果 > target, 则不可以分割成功
         *
         * 定义：
         *      dp[i][j], n行 target+1 列，
         *          表示从[0, i]中取若干个正整数(可以是0), 判断是否可以和为j
         * 初始化：
         *      dp[n][target + 1] = false;
         * 边界：
         *      dp[i][0] = true;    当待组合数为0时，任何区间都可以有一种取法就是不取
         *      dp[0][nums[0]] = true;  只有一个正整数可以选取
         * 状态：
         *      dp[i][j] =
         *          dp[i-1][j] || dp[i-1][j-nums[i]]     1   j >= nums[i]，当前点不取 || 当前点取
         *          dp[i-1][j]                           2   j < nums[i], 当前点无法取
         *
         *
         * 返回：
         */
        int len = nums.length;
        //三种无法产生结果的情况要提前终止
        if (len < 2)    return false;               //1、长度不够
        int sum = 0, maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 == 1)   return false;           //2、总和是奇数
        int target = sum / 2;
        if (maxNum > target)    return false;       //3、最大元素大于总和的一半

        //定义dp， 以及定义边界
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;                //对于目标和为0的情况来说，一定是可以存在的，即不取
        }
        dp[0][nums[0]] = true;              //对于只取第一个数的情况
        //状态转移
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {//在0-i内任意取值，是否能组成j
                if (j >= nums[i]) { //当前的值比较小，意思就是这个值可以取也可以不取
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //返回
        return  dp[len - 1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}