package leetcode.editor.cn;
import java.util.*;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 935 👎 0

public class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 滑动窗口
         *
         * 每次s切片，长度同p，这是窗口
         * 窗口每次维护每种字母的数量，如果窗口的每种字母和字符串p中的每种字母数量相同，则说明是异构词
         */
        //查看题目发现长度是有可能超出的
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (pLen > sLen)    return ans;
        //维护字母的数组需要分别存储
        int[] sCount = new int[26]; //存放的是s的散列数组
        int[] pCount = new int[26]; //存放的是p的散列数组
        for (int i = 0; i < pLen; i++) {    //计算两个散列数组的存储情况
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        //边界情况
        if (Arrays.equals(sCount, pCount))
            ans.add(0);
        //开始使用滑动窗口
        for (int i = 0; i < sLen - pLen; i++) { //滑动过程中要动态修改字母的情况
            --sCount[s.charAt(i) - 'a'];    //来到一个新位置，丢弃左边界
            ++sCount[s.charAt(i + pLen) - 'a'];//加入右边界
            if (Arrays.equals(sCount, pCount))  //每次更新完了比较一下
                ans.add(i + 1);
        }
        return ans;
        
        
        
        
        
        
        //可用但是超时了
//        int lenP = p.length();
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < s.length() - lenP; i++) {
//            boolean flag = false;
//            flag = compare(s.substring(i, i + lenP), p);
//            if (flag)
//                ans.add(i);
//        }
//        return ans;
    }
//    public boolean compare(String subS, String p) {
//        char[] charS = subS.toCharArray();
//        Arrays.sort(charS);
//        String newS = new String(charS);
//        char[] charP = p.toCharArray();
//        Arrays.sort(charP);
//        String newP = new String(charP);
//        if (newS.equals(newP))
//            return true;
//        return false;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

}