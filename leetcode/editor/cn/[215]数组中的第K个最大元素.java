package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1727 👎 0

import java.util.Arrays;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //快排
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
//        //哈哈可以用，但是这么写面试肯定挂了
//        int len = nums.length;
//        Arrays.sort(nums);
//        return nums[len - k];
    }
    public static void quickSort(int[] nums, int left, int right) {
        int i = left, j = right;
        if (i < j) {
            int saved = nums[i];
            while (i < j) {
                while (i < j && saved <= nums[j])
                    j--;
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] <= saved)
                    i++;
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = saved;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}