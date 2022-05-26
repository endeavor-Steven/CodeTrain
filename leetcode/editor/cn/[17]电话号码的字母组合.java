package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1914 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        /**
         * 方法1：使用回溯法
         * 注意，看到组合的时候要想到回溯
         * 1、使用哈希表存储每个数字对应的字母
         * 2、进行回溯
         *
         * 回溯模板注意看清楚
         * 1、定义结果集、定义中间集、定义回溯函数
         * 2、回溯函数中，要判断结束条件，对中间量进行遍历，组装结果，然后递归，回退第一个量
         */
        List<String> ans = new ArrayList<>();
        if (digits.length() < 1)    return ans;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        backtrack(ans, map, digits, 0, sb);
        return ans;
    }
    public void backtrack(List<String> ans, Map<Character, String> map, String digits, int carry, StringBuilder sb) {
        if (carry == digits.length()) {
            ans.add(sb.toString());
            return ;
        } else {
            char number = digits.charAt(carry); //取出当前回溯的号码
            String numberToLetters = map.get(number); //取出此号码对应的字母串
            for (int i = 0; i < numberToLetters.length(); i++) {
                sb.append(numberToLetters.charAt(i));
                backtrack(ans, map, digits, carry + 1, sb);
                sb.deleteCharAt(carry);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}