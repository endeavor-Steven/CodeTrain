package leetcode.editor.cn;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1154 👎 0

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 方法1：
         * 异构词的排序结果肯定是相同的。可以把这个当作Hash的键
         */
        Map<String, List<String>> map = new HashMap<>();//k:sorted, v:异构词组
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedArr = new String(arr);//对单个串进行排序转化

            List<String> tmp = new ArrayList<>();//存储异构词
            tmp = map.getOrDefault(sortedArr, new ArrayList<String>());
            tmp.add(str);//有的取出来加，没有的就默认一个新的
            map.put(sortedArr, tmp);
        }
        return new ArrayList<List<String>>(map.values());//注意这里的map.values()返回的是一个集合
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}