package leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 437 👎 0

public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        /**
         * 循环打印的核心，构建四个边界，上top,下bottom,左left,右right。
         * 构建四个打印方向： 从左往右，从上往下，从右往左，从下往上
         * 四个方向循环打印，每个方向的动作如下：
         *      1、根据边界打印，枚举的值放入结果集
         *      2、边界向内收缩1
         *      3、边界相遇则停止打印
         *
         * 从左往右：判定左右边界，收缩是上界加一，上界大于下届时未结束
         * 从上往下，判定上下边界，收缩时右界减一，左界小于右界时未结束
         * 从右往左，判定右左边界，收缩时左界加一，上界大于下届时未结束
         * 从下往上，判定下上边界，收缩时下界减一，左界小于右界时未结束
         */
        if (matrix.length == 0)
            return new int[0];
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int[] res = new int[(bottom + 1) * (right + 1)];
        int index = 0;
        while (true) {
            for (int i = left; i <= right; i++) res[index++] = matrix[top][i];//从左往右
            if (++top > bottom) break;    //上下界相遇则停止
            for (int i = top; i <= bottom; i++) res[index++] = matrix[i][right];//从左往右
            if (--right < left) break;    //左右界相遇则停止
            for (int i = right; i >= left; i--) res[index++] = matrix[bottom][i];//从右往左
            if (top > --bottom) break;    //上下界相遇则停止
            for (int i = bottom; i >= top; i--) res[index++] = matrix[i][left];//从下往上
            if (++left > right) break;    //左右界相遇则停止
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}