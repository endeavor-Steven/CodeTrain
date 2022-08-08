package leetcode.editor.cn;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 367 👎 0

public class ChouShuLcof{
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        /**
         * dp
         * 首先分析一下基本的地推规则，丑数 = 某个因子 * 较小的一个丑数
         *      x = min (xa * 2, xb * 3, xc * 5)
         *      xa是第一个乘2大于x的丑数, xb是第一个乘3大于x的丑数, xc是第一个乘5大于x的丑数
         *      可设置指针 a,b,c 指向首个丑数（即1），循环根据递推公式得到下个丑数，并每轮将对应指针执行+1即可。
         *
         * 定义：dp[i]， 表示第i+1个丑数
         * 转移：dp[i] = min(dp[a]*2, dp[b]*3, dp[c]*5)
         * 初始：dp[0] = 1;
         * 返回：dp[n-1]
         *
         */
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) ++a;
            if (dp[i] == n3) ++b;
            if (dp[i] == n5) ++c;
        }
        return dp[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}