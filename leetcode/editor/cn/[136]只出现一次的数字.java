package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2441 👎 0

public class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        /**
         * 使用异或
         * 原理分析：
         *      相同的值求异或等于0，等于说在遍历过程中等于抵消了，
         *      而0和任何数异或都等于这个数本身，
         *      所以遍历一整遍之后，出现两次的值全部抵消了为0，0^singleNumber = singleNumber
         * 异或操作符^
         */
        int ans = 0;
        for(int num : nums)
            ans ^= num;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}