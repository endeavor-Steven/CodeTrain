package leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 553 👎 0

public class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        /**
         * 首先要解决的问题是，怎么得到数位之和，可以封装成一个函数来写
         * 同时引入visit数组来判断哪些坐标可以到达，搜索方向只要注意向下向右就可以了
         */
        if (k == 0) return 1;
        boolean[][] visit = new boolean[m][n];
        int ans = 1;
        visit[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k)
                    continue;
                // 边界判断
                if (i > 0)
                    visit[i][j] |= visit[i - 1][j];
                if (j > 0)
                    visit[i][j] |= visit[i][j - 1];
                ans += visit[i][j] ? 1 : 0;
            }
        }
        return ans;
    }
    private int get(int x) {//获取到位数和
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}