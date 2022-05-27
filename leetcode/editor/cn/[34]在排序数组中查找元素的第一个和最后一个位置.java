package leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1718 👎 0

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
         * 方法：二分查找
         * 思路解析：其实是要找到第一个等于taget的位置，和第一个大于target的位置-1
         * 分两个阶段
         *
         * 一个经验之谈：，如果满足条件选择的是l = mid，那么mid那里就加个1，写成l + r + 1 >> 1
         * 取中值还可以是l + r >> 1,加速
         */
        int n = nums.length;
        int[] ans = new int[]{-1, -1};
        //异常值剥离
        if (n == 0) return ans;
        //先找第一个值
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) /2;
            if (target < nums[mid]) {
                r = mid;
            } else if (target == nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target)
            return ans;
        ans[0] = l;
        //找最后一个值
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) /2;//注意一下这里
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target == nums[mid]) {
                l = mid;
            } else {
                l = mid;
            }
        }
        ans[1] = l;
        return ans;
    }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}