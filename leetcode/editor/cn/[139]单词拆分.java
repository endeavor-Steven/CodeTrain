package leetcode.editor.cn;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1647 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak{
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 动态规划
         * 状态定义：boolean dp[i]， 表示字符串s的 前i个字符组成的字符串s[0， i-1] 是否能被 空格 拆分成 若干个字典中出现的单词。
         * 每次从0~i-1依次枚举j， 判断s1[0, j-1]和s2[j, i-1]是否合法。如果都合法则二者拼成的字符串也合法
         * 由dp[i-1]可以得出dp[i]的值可知，dp[j]可以由dp[j-1]得到,因此聚焦于获得s2[j, i-1]的合法性
         * 状态转移dp[i] = dp[j] && check(s[j, i-1]);      check用来判断s2的合法性
         * 状态边界dp[0] = true;认为空串合法
         *
         * 对于检查一个字符串是否出现在给定的字符串列表里一般可以考虑哈希表来快速判断
         * 如果分割点 j到 i的长度已经大于字典列表里最长的单词的长度，那么就结束枚举，
         */
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; //dp[0]是空串
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {//先找0~i-1
            for (int j = 0; j < i; j++) { //再找0~j-1, j~i-1
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;//目的是找到合法性，只要合法了就可以停止了
                }
            }
        }
        return dp[s.length()];

//      优化一下，dp[i]只需要往前探索到词典里最长的单词即可，优化后击败100%
//      //如果分割点 j到 i的长度已经大于字典列表里最长的单词的长度，那么就结束枚举，
//        public boolean wordBreak(String s, List<String> wordDict) {
//            int len = s.length(), maxw = 0;
//            boolean[] dp = new boolean[len + 1];
//            dp[0] = true;
//            Set<String> set = new HashSet();
//            for(String str : wordDict){
//                set.add(str);
//                maxw = Math.max(maxw, str.length());
//            }
//            for(int i = 1; i < len + 1; i++){
//                for(int j = i; j >= 0 && j >= i - maxw; j--){
//                    if(dp[j] && set.contains(s.substring(j, i))){
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//            return dp[len];
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}