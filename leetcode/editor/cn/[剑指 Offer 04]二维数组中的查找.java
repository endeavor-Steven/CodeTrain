package leetcode.editor.cn;
import java.util.*;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 717 👎 0

public class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /**
         * 蛇形走位
         * 使用二叉搜索树的模式来找
         *
         * 这里说明一个问题，
         * 从右上角开始搜索的话，要依次判断，数组空 || 行空 || 列空 的情况
         * 从左下角开始搜索的话，可以避免这种情况判断的情况———— **建议使用这种方法**
         */
        //左下角
        int i = matrix.length - 1, j = 0;
        while (i >= 0  && j < matrix[0].length ) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                ++j;
            else
                --i;
        }
        return false;





        //右上角
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return false;
//        int n = matrix.length, m = matrix[0].length;
//        int i = 0, j = m - 1;
//        while (i < n && j >=0 ) {
//            if (matrix[i][j] == target)
//                return true;
//            else if (matrix[i][j] < target)
//                ++i;
//            else
//                --j;
//        }
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}