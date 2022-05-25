package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4810 👎 0

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 1\特判，对于数组长度 nn，如果数组为 null 或者数组长度小于 3，返回 []。
         * 2\对数组进行排序。
         * 3\遍历排序后数组：
         *  若 nums[i]>0因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
         *  对于重复元素：跳过，避免出现重复解
         *  令左指针 L=i+1，右指针 R=n-1，当 L<R时，执行循环：
         *      当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
         *      若和大于 0，说明 nums[R] 太大，R左移
         *      若和小于 0，说明 nums[L] 太小，L右移

         */
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);//方便过滤重复值

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
               return ans;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);
                    while (left < right && nums[left + 1] == nums[left])  ++left;
                    while (left < right && nums[right - 1] == nums[right])  --right;
                    ++left;
                    --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}