package leetcode.editor.cn;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1286 👎 0

import java.util.Arrays;

public class SortColors{
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        /**
         * 方法一：直接统计再生
         */
//        int count0 = 0, count1 = 0, count2 = 2;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) ++count0;
//            if (nums[i] == 1) ++count1;
//            if (nums[i] == 2) ++count2;
//        }
//        int p = 0;
//        while (p < nums.length) {
//            if (count0 > 0) {
//                nums[p++] = 0;
//                count0--;
//            } else if (count1 > 0) {
//                nums[p++] = 1;
//                count1--;
//            } else {
//                nums[p++] = 2;
//                count2--;
//            }
//        }
        /**
         * 方法二：
         * 两趟遍历，一趟找0，一趟找1
         */

        /**
         * 方法三：
         * 一趟遍历，三指针
         */
        int p0 = 0, p1 = 0, p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[p2++] = 2;
                nums[p1++] = 1;
                nums[p0++] = 0;
            } else if (nums[i] == 1) {
                nums[p1++] = 1;
                nums[p0++] = 0;
            } else {
                nums[p0++] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}