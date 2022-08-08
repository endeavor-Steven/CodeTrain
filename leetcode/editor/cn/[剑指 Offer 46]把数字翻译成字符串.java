package leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 468 👎 0

public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        /**
         * 动态规划
         * 定义：dp[i], 以i结尾的翻译方案的数量，
         * 转移：
         *      x1x2x3x4的方案如果是f(n-2),x1x2x3x4x5的方案如果是f(n-1)
         *      x1x2x3x4x5x6,当x6不在10-25之间，那么他的翻译方案和f(n-1)相同
         *                                    不然他的翻译方案就是f(n-1) + f(n-2)
         *      dp[i] =
         *          dp[i-1] + dp[i-2] , nums[i]和 nums[i-1]组成的两个数字都可以被翻译,数字在10-25内
         *          dp[i-1]
         * 初始化：dp[0] = dp[1] = 1;无数字和第一个数字
         * 返回：dp[n]
         * 遍历方式：在字符串切片的时候前一位xi和后一位xi+1要组成一个两位数，记得提位
         */
        String strs = String.valueOf(num);
        int a = 1, b = 1;//dp[0], dp[1]
        for (int i = 0; i + 1 < strs.length(); i++) {
            String tmp = strs.substring(i, i + 2);//依次切片一对数来判断范围，用来判断使用哪种动态方案
            //切片部分如果不在10前面  而且  在25前面  就是第一种，不然就是第二种
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;//每次更新一组dp[n-2]  dp[n-1]
            a = c;//
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}