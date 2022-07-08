package leetcode.editor.cn;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 916 👎 0

public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        /**
         * 滑动窗口+回文串判断
         * 就是性能有点差
         *
         * 看看回文串判断是否可以使用动态规划
         */
        /**
         * 动态规划判断回文串
         * 定义：
         *      dp[i][j] = true;    字符转从i~j是字符串
         * 初始化与边界：
         *      dp[i][j] = true;    遍历过程中可以包括了
         * 状态转移：
         *      dp[i][j] = ( j - i > 2 || dp[i+1][j-1]  )&&  s[i] == s[j], 这个地方一定不要忘了长度判断
         */

        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    ++count;
                }
            }
        }
        return count;



//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                if (classify(s.substring(i, j)))
//                    ++count;
//            }
//        }
//        return count;
    }
//    public boolean classify(String s) {
//        char[] array = s.toCharArray();
//        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
//            if (array[i] != array[j])
//                return false;
//        }
//        return true;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}