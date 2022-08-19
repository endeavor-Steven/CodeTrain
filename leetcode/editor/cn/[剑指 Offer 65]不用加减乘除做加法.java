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
    /**
     * 在位运算的角度讲，每个位的操作分为 进位的情况 和 当前位 的情况
     * 通过观察可以发现，在两个数进行求和的时候，
     *      ==>>1.n = a ⊕ b         非进位的和，第i位，操作和异或是一样的
     *          2.c = (a & b) << 1  进位，第i+1位，操作是与操作后往左进一
     *      ==>>和sum = n + c  即 s = a ^ b + (a & b) << 1
     *
     *      采用递归思想:
     *          虽然s = a + b = n + c，但是n + c还是用了'+'，
     *          因此我们对n + c再次采用这种运算
     *          (也就是把n当成a，c当成b，继续做a+b运算。看似无限循环，但是进位c总会有等于0的时候，此时结果就等于n)
     *      非递归：
     *          循环求n和c，直至进位c = 0; 此时s = n, 返回n即可。
     *
     */
    public int add(int a, int b) {
        while(b != 0){//因为不允许用+号，所以求出异或部分和进位部分依然不能用+号，所以只能循环到没有进位为止
            int c = (a & b) << 1; //拿到进位
            a ^= b;               //拿到非进位和
            b = c;                //迭代，让b = 进位
        }
        return a;
    }
    public int add2(int a, int b) {
        if (b == 0)
            return a;
        return add(a ^ b, (a & b) << 1);        // 转换成非进位和 + 进位
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}