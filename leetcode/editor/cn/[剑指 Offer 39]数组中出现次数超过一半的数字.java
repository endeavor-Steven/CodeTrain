package leetcode.editor.cn;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 304 👎 0

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /**
         * 摩尔投票法
         * 如果众数为x, 长度为n
         *      结论一：枚举所有的数，如果是众数+1， 不是众数-1， 那么最终的票肯定大于0
         *      结论二：如果数组前a个数的票和为0， 那剩下的n-a个票和肯定大于0
         * 根据推论，从第一个值开始假设为众数机票，每次出现计票数为0的时候，则剩下的值里面还有众数，且最后一次假设的为众数。
         */
        int voted = 0, mod = 0;//计票合，众数（当前假设的众数）
        //当num=mod，
        for (int num : nums) {
//            if (num == mod)
//                mod = num;
//            voted += num == 0 ? 1 : -1;        //结论判断当计票合=0，则当前的数字num是众数。
//                                               //num==mod  ++voted
            if (voted == 0)
                mod = num;
            if (num== mod) ++voted;
            else --voted;
        }
        return mod;

//        //补充：也许有些题目里面的众数长度没有超过一半
//        int count = 0;
//        for (int num : nums)
//            if (num == mod)
//                ++count;
//        return count > nums.length / 2 ?  mod : 0;//有则返回不然返回0
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}