package leetcode.editor.cn;
import java.util.*;
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 589 👎 0

import java.util.ArrayList;
import java.util.List;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        //这是我一直习惯的回溯法用法，但是这种做法效率不是很高，下面给一种快很多的
        char[] letters = s.toCharArray();
        Set<String> ans = new HashSet<>();
        StringBuilder comb = new StringBuilder();
        boolean[] visit = new boolean[s.length()];
        trackback(letters, ans, comb, visit, 0);
        String[] res = ans.toArray(new String[ans.size()]);
        return res;
    }

    public static void trackback(char[] letters, Set<String> ans, StringBuilder comb, boolean[] visit, int curr) {
        if (curr == letters.length) {
            ans.add(new String(comb.toString()));
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb.append(letters[i]);
                trackback(letters, ans, comb, visit, curr + 1);
                comb.deleteCharAt(comb.length() - 1);
                visit[i] = false;
            }
        }
    }
}


class Solution2 {
    /**
     * 还是回溯，但是不太一样
     * 通过字符交换，
     *      先固定第 1 位字符（ n 种情况）、
     *      再固定第 2 位字符（ n−1 种情况）、
     *      ... 、
     *      最后固定第 n 位字符（ 1 种情况）。
     * 当字符串存在重复字符时，排列方案中也存在重复的排列方案。
     * 为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，即遇到重复字符时不交换，直接跳过。
     * 从 DFS 角度看，此操作称为 “剪枝” 。
     * 还是使用set进行重复的过滤
     *
     * 算法流程：
     *      递归出口：长度达标就将临时的字符串加到结果集中
     *      递归的参数：固定的位数x
     *      递归的流程：
     *          1.定义一个Set用来过滤重复的情况
     *          2、for(i = x; i < len; i++)
     *              3、枚举的新字符重复，则continue
     *              4、不重复就加入set,
     *              5、交换x和i位的值，唤醒dfs(x+1);
     *              4、交换回x和i
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation2(String s) {

        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}