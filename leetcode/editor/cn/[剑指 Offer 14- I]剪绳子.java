package leetcode.editor.cn;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
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
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 473 👎 0

public class JianShengZiLcof{
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        /**
         * 数学规律
         * 一个整数有多少种组合方式 n = n1 + n2 + ... + nn
         * 每种组合方式的乘积是多少 max(n1 x n2 x ... nn)
         *
         * 结论1：等段分的乘积最大
         * 结论2：段长为3时，乘积会尽可能的大
         * 极值点的结论
         */
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);        //b=0,整除了,
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;//b=1,最后一段长度为1,观察最后两段, 3 x 1 < 2 x 2
        return (int) Math.pow(3, a) * 2;                //b=2,最后一段长度为2,观察最后两段, 保留
    }
    public int cuttingRope2(int n) {
        /**
         * 激情dp
         * 思路解析
         * 绳子长度n >= 2时， 至少可以剪成两段。
         * 假设k是剪出来的第一段绳子，剩下的部分是n-k, n-k可以不继续剪 或者 继续剪成至少两段绳子。（重复子问题->dp）
         *
         * 定义；  dp[i] 表示将长度为 i 的绳子剪成至少两段绳子之后，这些绳子长度的最大乘积
         * 状态：  长度为i的绳子，剪出的第一段绳子长度j，(1 <= j < i),要考虑到这几种情况
         *          1、i被剪成 j 和 i-j两段，且i-j无法再剪，此时得到乘积 j * (i - j)
         *          2、i被剪成 j 和 i-j两段，且i-j可以再剪，此时得到乘积 j * dp[i-j]
         *          dp[i] = max( j * (i - j), j * dp[i-j] )
         * 初始化：dp[0] = dp[1] = 0;
         * 返回： dp[n]
         * 遍历顺序：正序遍历
         */
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = dp[1] = 1;  // 指长度为1的单独乘积为1
        // 遍历[2,n]的每个状态
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                // 求出两种转移情况(乘积个数为2和2以上)的最大值
                int tmp = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(tmp, dp[i]);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}