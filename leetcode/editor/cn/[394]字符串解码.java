package leetcode.editor.cn;

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 👍 1207 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString{
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        /**
         * 双栈辅助
         *
         */
        StringBuffer ans=new StringBuffer();
        Deque<StringBuffer> strStack=new LinkedList<>();
        Deque<Integer> numStack=new LinkedList<>();
        int number = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))    //当遍历到字符时
                number = number * 10 + c - '0';//先把数字字符变成数字累积下来，防止有超过个位的情况
            else if(c == '['){          //遍历到左括号
                strStack.push(ans);     //字符串压入字符栈
                numStack.push(number);  //数字压入数字栈
                ans = new StringBuffer();//更新字符串
                number = 0;             //更新数字
            }else if(Character.isAlphabetic(c)){ //遍历到英文字母时
                ans.append(c);  //把字母加到字符串后面
            }else{                       //遍历到右括号
                StringBuffer ansTmp = strStack.pop();//从字符栈中取出一组[]中的解码字符
                int tmp = numStack.pop();   //取出这组字符的扩充倍数
                for(int i = 0; i < tmp; i++)    //开始倍增
                    ansTmp.append(ans);
                ans = ansTmp;
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}