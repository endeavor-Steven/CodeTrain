package leetcode.editor.cn;
import java.util.*;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3273 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        /**
         * 使用栈匹配
         * 这个题目有一点点怪，就是说出现了左括号，下一个一定会是右括号。不然就不会成对出现
         */
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.peek() == null) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')' ) {
                if (stack.peek() == '(') {
                    stack.poll();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (s.charAt(i) == ']' ) {
                if (stack.peek() == '[') {
                    stack.poll();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (s.charAt(i) == '}' ) {
                if (stack.peek() == '{') {
                    stack.poll();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}