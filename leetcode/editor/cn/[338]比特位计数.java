package leetcode.editor.cn;

//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。 
//
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？ 
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ） 
// 
// 
// 
// Related Topics 位运算 动态规划 👍 1033 👎 0

public class CountingBits{
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countBits(int n) {
        /**
         * 使用奇偶性特征
         * 对于所有的数字，只有两类：
         * --奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
         *    举例： 0 = 0       1 = 1
         *          2 = 10      3 = 11
         * --偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
         *   举例：   2 = 10       4 = 100       8 = 1000
         *           3 = 11       6 = 110       12 = 1100
         * --另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
         *
         */
//        int[] ans = new int[n + 1];
//        ans[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 1)
//                ans[i] = ans[i-1] + 1;
//            else
//                ans[i] = ans[i / 2];
//        }
//        return ans;

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + i % 2; //可以改成位运算加速
        }
        return result;












//        //可以，但是效率低
//        if (n == 0)
//            return new int[]{0};
//        int[] ans = new int[n + 1];
//        ans[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            int count = 0;
//            for (int j = i; j != 0 ; j = j >> 1) {
//                if ((j & 1) == 1)
//                    ++count;
//            }
//            ans[i] = count;
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}