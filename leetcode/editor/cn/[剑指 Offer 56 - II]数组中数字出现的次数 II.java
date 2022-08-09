package leetcode.editor.cn;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 368 👎 0

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        /**
         * 给我写肯定是HashMap了，换个别人的思路
         * 遍历统计
         * 建立一个32位长度的数组，记录所有的num的每一位的1出现的次数，这里位数迭代的时候是无符号右移
         * 将数组的每个位都对3取模，结果是只出现一次的各二进制位
         * 然后利用左移和或运算，把数组各位组装成一个整数
         */
        int[] res = new int[32];
        for(int num : nums) {   //所有的num的各位相加全部存入res
            for (int i = 0; i < 32; i++) {
                res[i] += num & 1;   //更新第i位,之前是有值得，别搞掉了
                num >>>= 1;
            }
        }
        int single = 0;
        for (int i = 31; i >= 0; i--) {
            single <<= 1;
            single |= res[i] % 3;   ////过滤之后只剩下那个一个数的各位值了，然后从右往左给他接上去
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}