package leetcode.editor.cn;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 1189 👎 0

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 动态规划
         * 状态：dp[i][j], 以matrix[i][j]为右下角的正方形最大边长
         *      nums[i][j] = 0 => dp[i][j] = 0
         * 转移：dp[i][j] = min(dp[i-1][j] , dp[i][j-i] , dp[i-1][j-1])  ， 最小的那个是最不受限制的
         * 边界：dp[i][j] = 1; nums[i][j] = 1 && (i == 0 || j == 0)
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int cols = matrix.length, rows = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] == '1') {  //当前遍历到符合地区启动要求的点
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans *ans;

        //暴力破解
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//        int cols = matrix.length, rows = matrix[0].length;
//        int ans = 0;
//        for (int i = 0; i < cols; i++) {
//            for (int j = 0; j < rows; j++) {
//                if (matrix[i][j] == '1') {//找一个左上角
//                    ans = Math.max(ans, 1);
//                    int delta = Math.min(cols - i, rows - j);//距离边界的长度
//                    for (int k = 1; k < delta; k++) {//判断新增k行k列的情况
//                        boolean flag = true; //判断找到方块的情况
//                        if (matrix[i + k][j + k] == '0') {
//                            break;
//                        }
//                        for (int l = 0; l < k; l++) {
//                            //一次检查两个维度
//                            if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if (!flag)
//                            break;
//                        else
//                            ans = Math.max(ans, k + 1);//k只是边，还有中心点
//                    }
//                }
//            }
//        }
//        return ans * ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}