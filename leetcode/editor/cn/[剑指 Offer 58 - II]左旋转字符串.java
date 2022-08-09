package leetcode.editor.cn;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 285 👎 0

public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路一，三次反转，这个好处是空间消耗低
     */
    public String reverseLeftWords(String s, int n) {
        /**
         * 思路二，生成一个新的字符串，其实也就是切片
         */
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}