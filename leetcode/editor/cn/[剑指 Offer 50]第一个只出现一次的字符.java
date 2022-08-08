package leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 253 👎 0

import java.util.*;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar1(String s) {
        /**
         * HashMap和LinkedHashMap都可以实现，都是用value来保存值得部分
         * 但是不同的地方是如果是HashMap在第二次遍历要对数组进行检查
         * LinkedHashMap可以直接就查询出来第一次得情况
         */
        Map<Character, Boolean> map = new HashMap<>();
        char[] strs =  s.toCharArray();
        for (char str : strs)
            map.put(str, !map.containsKey(str));
        for (char str : strs)
            if (map.get(str))
                return str;
        return ' ';
    }
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] strs =  s.toCharArray();
        for (char str : strs)
            map.put(str, !map.containsKey(str));
        for (Map.Entry<Character, Boolean> entry : map.entrySet()){
            if (entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}