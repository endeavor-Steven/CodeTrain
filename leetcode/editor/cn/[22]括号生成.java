package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2663 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        /**
         * 方法1：回溯法
         * 注意：提到组合要想起回溯法
         *
         * 关键的地方在于，要跟踪到目前为止左括号和右括号的数量。
         * 在回溯过程中，
         * 要注意！有括号的数量小于左括号的时候，才加一个
         */
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        backtrack(ans, sb, 0, 0, n);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder sb, int left, int right, int n){
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            backtrack(ans, sb, left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left ) {//注意这里，右括号的情况要比左括号少
            sb.append(')');
            backtrack(ans, sb, left, right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}