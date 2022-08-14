package leetcode.editor.cn;
import java.util.*;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 👍 368 👎 0

public class BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        /**
         * ‘.’出现正确情况：只出现一次，且在e的前面
         * ‘e’出现正确情况：只出现一次，且出现前有数字
         * ‘+’‘-’出现正确情况：只能在开头和e后一位
         *
         * 另外numFlag配合使用
         */
        if (s == null || s.length() == 0) return false;
        s = s.trim();//去掉首位空格
        boolean numFlag = false;    //三个flag都来标明数字、小数点、符号e是不是出现过
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {//枚举所有的位数，然后找出正确情况
            //出现数字位,则标识数字位
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            //第一次出现小数点，且e未出现
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            //第一次出现e，且已经出现了数字
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //对于存在e的情况，接收到e时已经判断前面有数字了，并将 numFlag 重置，
                //意味着当接收到 e 后，如果后面没有数字（没有将 numFlag 重新标记为真），那么也是不对的。
            //出现了正负号且位置是首位或者e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

            //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;//首先不管哪种情况都必须要有数字，没有数字肯定不对
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}