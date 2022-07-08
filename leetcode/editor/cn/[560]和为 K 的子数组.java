package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1567 👎 0

import java.util.Arrays;

public class SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ans = 0;
    public int subarraySum(int[] nums, int k) {
        /**
         * 思路解析：
         * 枚举所有的数，枚举的数为左边界。然后从右边界从左边界开始往右。
         * 右边界搜寻到的值开始累加，当这个值匹配结果则计数器+1
         * 返回计数器
         */
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k)
                    ++count;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}