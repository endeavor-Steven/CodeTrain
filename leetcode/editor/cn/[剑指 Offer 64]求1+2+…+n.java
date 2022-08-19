package leetcode.editor.cn;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 👍 523 👎 0

public class Qiu12nLcof{
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;
    public int sumNums(int n) {
        /**
         * 各种限制，那么就要想办法
         *  && 操作和 || 操作都是在左边的运算数出异常的时候直接短路出结果的,可以用来做条件判断
         *  这个地方可以使用递归，配合上面的操作符完成终止 n > 1 && sumNums(n - 1)
         */
        boolean x =  n > 1 && sumNums(n-1) > 0;
        res += n;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}