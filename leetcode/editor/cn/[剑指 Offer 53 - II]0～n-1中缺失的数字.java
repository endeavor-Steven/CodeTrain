package leetcode.editor.cn;

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 295 👎 0

public class QueShiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        /**
         * 二分法
         * 数组分为两个部分
         *      左边的数组：nums[i] = i
         *      右边的数组：nums[i] ≠ i
         *      显然，缺失的数组肯定是个在右边的数组内的第一个的索引的值，
         *
         * 算法流程：
         *      初始化左右边界，找到中点
         *      nums[mid] = mid,则右数组的首位还在右边，l = mid + 1;
         *      nums[mid] ≠ mid,则左数组的末位还在左边，r = mid - 1;
         *      跳出时，左指针为右数组的首位，右指针为左数组的末位，返回i
         */
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] != mid) j = mid - 1;
            else i = mid + 1;
        }
        return i;

    }
        public int missingNumber2(int[] nums) {
        /**
         * 一次枚举找数字
         */
        if (nums[0] == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}