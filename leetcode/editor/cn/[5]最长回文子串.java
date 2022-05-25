package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5253 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        /**
         * 方法一：动态规划
         * 定义状态：dp[i][j]表示是否为回文串
         * 1、状态转移方程：dp[i][j] = dp[i-1][j-1] and (s[i] == [j])，即判断一个串是否为回文要看两边和子串
         * 2、状态边界：长度为1的字串是，长度为2且两值相同则是,即长度是严格大于2的(  j-1  - (i - 1) + 1 > 2  ==> j-i < 3)
         * 3、初始化dp[i][i] = true
         * 4、输出:得到一个状态为true的时候 ，记录起点和长度用于切片
         *
         * 注意点：dp可以看成一个二维表格，i≤j,即对角线以上的上三角，i：行，是左边界，j：列是右边界
         * 根据状态转移方程，i-1, j-1 的位置是i, j的左下角，如果采取先行后列的方法的话，左下角参考不到，所以采用先列后行的填写方法
          */
        int len = s.length();
        if (len < 2)  return s;//特殊判断

        int maxLen = 1, begin = 0;//记录最长的长度和起始位置。
        char[] charArray = s.toCharArray();

        boolean[][] dp = new boolean[len][len];// dp[i][j]:表示s[i][j]是否是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;// 初始化：单独一个字符肯定是回文子串
        }
        // 经验：注意点
        for (int j = 1; j < len; j++) { // 上三角区域，按列从上到下填
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {// 首尾不相等时，必不是回文串
                    dp[i][j] = false;
                } else {
                    // 首尾相等时，有2种情况
                    // 情况1：s[i...j]长度不超过3，不用检查必为回文串
                    // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断
                    dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                }
                // 更新max和begin
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}