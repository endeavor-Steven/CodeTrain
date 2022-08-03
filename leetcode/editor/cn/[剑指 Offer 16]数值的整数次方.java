package leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 329 👎 0

public class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        /**
         * 二分法实现快速幂
         * 首先理解，一个二进制数可以用幂级展开成十进制， 反过来就是十进制可以是二进制多项和
         * 其次理解，一个幂级数的指数相加，等于两个幂级数的乘积
         *
         * 二分法的加速，x^n = x^(n/2) * x^(n/2) = x^(2(n/2)), 这里需要 n/2为整数，所以
         *      n % 2 == 0, x^n = x^(2(n//2))
         *      n % 2 == 1, x^n = x^(2(n//2)) * x
         *      目的是每次通过两个低次幂相乘 替代高次幂
         */
        if (x == 0) return 0;
        long realN = n; //int n
        if (realN < 0){ //指数负号的时候处理一下
            x = 1 / x;
            realN = 0 - realN;
        }
        //快速幂操作
        double ans = 1.0;
        while (realN > 0) {
            if ((realN & 1) == 1)//不能取整的时候向下取整多出来一个
                ans *= x;
            x *= x;
            realN >>= 1;//指数每次迭代为一半
        }
        return ans;
    }

    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}