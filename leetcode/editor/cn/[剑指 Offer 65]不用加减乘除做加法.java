package leetcode.editor.cn;

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 337 👎 0

public class BuYongJiaJianChengChuZuoJiaFaLcof{
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        /**
         * 在位运算的角度讲，每个位的操作分为 进位的情况 和 当前位 的情况
         * 通过观察可以发现，在两个数进行求和的时候，当前位的结果和异或操作一样，进位的结果和与运算一样（结果要左移哦）
         */
        while(b != 0){
            int c = (a & b) << 1; //拿到进位
            a ^= b;               //拿到当前位
            b = c;                //迭代
        }
        return a;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}