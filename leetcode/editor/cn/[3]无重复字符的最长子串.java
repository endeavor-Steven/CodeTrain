package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7626 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 方法一：使用HashSet的滑动窗口
         * 如果没发现重复元素，右指针加一，元素加入set，如果发现重复，左指针加一，移除set第一个元素
         */
//        if (s.length() == 1) return 1;
//        if (s.length() == 0) return 0;
//        Set<Character> set = new HashSet<>();
//        int left = 0, right = 0, max = 0;
//        while (right < s.length()) {
//            if (!set.contains(s.charAt(right))) {
//                set.add(s.charAt(right++));
//                max = Math.max(max, right - left);
//            } else {
//                set.remove(s.charAt(left++));
//            }
//        }
//        return max;

        /**
         * 方法2：使用HashMap的滑动窗口
         */
        if (s.length() == 1) return 1;
        if (s.length() == 0) return 0;
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);//同样的情况的话把左指针更新到最右边
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}