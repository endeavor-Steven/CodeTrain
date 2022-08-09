package leetcode.editor.cn;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 683 👎 0

public class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        /**
         * 分组异或
         * 如果所有的数过一次异或那么只能完成一个不重复数的需求
         * 假设这两个数为x, y，他们最少是有一个位不相同的,
         * 我们找到最低位（左边）的1，用这个作为标志，把所有值和标识做与操作，可以分成两组。
         * 由于高位是不同的，所以这两个值肯定会被分开，然后分别异或
         *
         * 如果对整个数组进行异或，那么最后的结果肯定是 x ⊕ y，如果这个结果某一位是1，那么说明x和y在这一位上是不一样的
         * 初始化一个辅助变量m=1，通过与运算从右向左循环判断，可获取整数x⊕y首位1，记录于m
         */
        int XeorY = 0;
        for(int num : nums) XeorY ^= num;   //拿到x ⊕ y
        int lowest1 = 1;
        while ((lowest1 & XeorY) == 0) lowest1 <<= 1;   //拿到x ⊕ y中最低位的1的位置
        int x = 0, y = 0;
        for(int num : nums){
            if ((lowest1 & num) == 0)
                x ^= num;
            else
                y ^= num;
        }
        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}