package leetcode.editor.cn;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 877 👎 0

public class ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        /**
         *思路一：排序
         * 整个数组可以分为三个部分numsA\numsB\numsC
         * 按照题目要求，numsB排序后，整个nums处于顺序状态
         * 于是可以额外存储数组，一次在头尾分别比对，寻找A和C的长度，总长度-这个长度就是结果
         */

        /**
         * 思路二：
         * 假设numB的区间， 是[l, r]。首先B和C中所有的元素应该是大于等于A中元素的
         * 即不等式 nums[i] <= min(nums[j]) , i+1 < j < n
         *
         * 先看左边界的定位方法：
         * 从大到小枚举index_i， 用一个变量min记录， i+1~n中最小的数.也就是min(nums[j])
         * 当枚举结束的时候， 最后一个满足不等式的i， 就是左边界
         * 左边界的左侧是numsA能取到的最大范围
         *
         * 无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
         */
        if (nums.length == 1)
            return 0;
        int len = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            if (max <= nums[i]) {
                max = nums[i];  //max始终是当前的最大值
            } else {
                right = i;   //寻找最右边 max > nums[i]的位置
            }
            if (min >= nums[len - i - 1]) {
                min = nums[len - i - 1];  //min始终是当前的最小值
            } else {
                left = len - i - 1;  //寻找最左边的 min < nums[i]的位置
            }
        }
        return right == 0 ? 0 : right -left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}