package leetcode.editor.cn;
import java.util.*;
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
         * 右边界寻找如果没发现重复元素，元素加入set，右指针加一
         * 如果发现重复,移除set第一个元素，左指针加一
         */
        if (s.length() == 1) return 1;
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        /**
         * 对方法一的优化
         * 方法2：使用HashMap的滑动窗口
         * 如果右边界在搜索的过程中，搜索到重复值，则将左边界更新到右边界+1（完成优化）
         * 用map.put完成对重复值的覆盖
         */

        if (s.length() == 1) return 1;
        if (s.length() == 0) return 0;
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);//同样的情况的话把左指针更新到最右边+1
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1); //长度问题要仔细
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}