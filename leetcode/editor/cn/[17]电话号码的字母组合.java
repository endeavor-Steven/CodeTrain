package leetcode.editor.cn;
import java.util.*;
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

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)   return ans;
        StringBuilder tmp = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(ans, tmp, 0, map, digits);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder tmp, int curr, Map<Character, String> map,String digits){
        /**
         * 回溯模板
         * ans是结果集，tmp是一条符合条件的值，curr表示当前的回溯位置，
         * map包含回溯信息，digits条件
         */
        if (curr == digits.length()) {
            ans.add(tmp.toString());
            return;
        }
        char number = digits.charAt(curr);//取出拨号的数字
        String str = map.get(number);//取出数字对应的字符串
        //每中字符都依次拿出来匹配依次
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            backtrack(ans, tmp, curr + 1, map, digits);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}