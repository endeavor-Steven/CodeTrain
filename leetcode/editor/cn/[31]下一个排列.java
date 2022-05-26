package leetcode.editor.cn;

//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1721 👎 0

public class NextPermutation{
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        /**
         * 方法1：
         * 题目解析，我们希望找到一个比当前序列大，但是涨幅最小的序列（大的这个范围是最小的）
         * 放在数组中，我们要找一个左边的小数，和右边的大数进行交换
         * 但是这个小数我们希望尽量靠右，这个大数尽量小。
         *这样就能保证每一次的涨幅尽可能地小
         *
         * 1、找靠右的小数
         * 我们从右往左找，根据nums[i] < nums[i+1]，能找到最右边的较小数nums[i]
         * （数形结合的角度，从尾部找到第一个升序对）
         * 注意:若此时找不到的话，说明这是一个降序序列，也就是最大的序列，可以全组反转找到最小的
         * 2、找较小的大数
         * 在1的基础上，从后往前一个数nums[j]，满足nums[i] < nums[j]，就能找到较小的大数nums[j]
         * （从数形结合的角度，交换完了后，这个升序更缓和，后面是一个更陡的降序）
         * 3、交换两数后，此时的[i+1, n]为降序，翻转这个区间变为升序
         */
        int len = nums.length - 1;
        int i = len - 1;
        for (; i >= 0 ; i--) {
            if (nums[i] < nums[i+1])
                break;//找到最右边的小数
        }
        if (i >= 0) {
            int j = len;
            for (; j >= 0 ; j--) {
                if (nums[j] > nums[i])
                    break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;//交换二者
        }
        reverse(nums, i + 1, len);


    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = 0;
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}