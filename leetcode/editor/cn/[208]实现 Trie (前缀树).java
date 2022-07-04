package leetcode.editor.cn;

//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 1210 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImplementTriePrefixTree{
    public static void main(String[] args) {
//        Solution solution = new ImplementTriePrefixTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    /**
     * HashMap实现
     * 此方法不是优解
     */
    Map<String, Boolean> map;//用map来模拟前缀树
    //初始化构造器
    public Trie() {
        map = new HashMap<>();
    }
    //向前缀树中插入字符串word
    public void insert(String word) {
        map.put(word, true);
    }
    //如果word在前缀树中则返回true, 否则返回false
    public boolean search(String word) {
        return map.getOrDefault(word, false);
    }
    //如果之前插入的字符串word的前缀之一为prefix则返回true， 否则返回false
    public boolean startsWith(String prefix) {
        //思路：遍历Map的key， 在长度匹配的情况下， 对keyset进行切片比较
        Set<String> mapKeySet = map.keySet();
        for (String str : mapKeySet) {
            if (str.length() >= prefix.length()) {
                String subWord = str.substring(0, prefix.length());
                if (subWord.equals(prefix))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}