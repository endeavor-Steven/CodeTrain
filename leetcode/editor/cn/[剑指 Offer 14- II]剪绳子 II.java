package leetcode.editor.cn;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 197 👎 0

public class JianShengZiIiLcof{
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        /**
         * 这个地方涉及到大数取模，没办法用dp
         * 使用取余解法的时候要考虑大数取余的方式
         *      1、循环取余（开销大一些，但是适合记下来）
         *      2、快速幂取余
         */
        if (n <= 3)  return n - 1;
        
        int mod = 1000000007;
        int a = n / 3, b = n % 3;
        long ret = 1;
        for (int i = 0; i < a; i++) {//由于是大数，就没办法使用pow快速求幂了，可以用循环法
            ret = ret * 3 % mod;
        }
        if (b == 0) return (int)(ret * 3 % mod);//这个地方要注意强制转型的括号
        if (b == 1) return (int)(ret * 4 % mod);
        return (int)(ret * 6 % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}