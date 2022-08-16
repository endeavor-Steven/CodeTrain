package leetcode.editor.cn;

//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 276 👎 0

public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        /**
         * 这道题是找规律的题
         *      参数定义：
         *      1、digit：几位数的这个几，位数，数字10，是一个两位数，位数为2
         *      2、start：几位数的最小数，起始数字，每个digit位数的起始数字
         *      3、count：几位数一共有多少个，数位数量，比如1~9，数位数量9；10~99，数位数量180；
         *      4、num：几位数的一个，数字，比如10， 12 是一个数字
         *      随着数位的增加各参数的迭代：
         *      1、位数                      digit = digit + 1
         *      2、当前数位下数字的数量         num = digit * 9
         *      3、当前数位下所有数字的数位数量  count = start * num (count = start * digit * 9)
         *      4、起始位的迭代               start = start * 10
         * 根据上面的定义，可以判定解题规则
         *      1、确定n所在的数字的位数，即确定digit
         *      2、确定n所在的数字，即确定num
         *      3、确定n是num中的哪一个数位，返回结果
         */
        int digit = 1;      //数位，当前是几位数
        //注意这里的类型，不然会超出的哦
        long start = 1;     //当前几位数的起始值
        long count = 9;     //当前几位数所有值一共有多少位
        // 1.确定n所在的数字的位数，n减去同一digit的所有位数count
        while (n > count) { //停下来的时候可以来到第n位数字所在的数位，换句话说就知道是几位数了，且知是道起始数开始的第n个数
            n -= count;     //每次用n减去一个数位内的数字数量，一共有n个数，可以用count个数来逼近
            digit += 1;     //每一次位数+1， 比如个位数迭代成十位数再迭代成百位数，每次位数+1
            start *= 10;    //起始数每次*10，比如个位数1迭代成十位数的10再迭代成百位数的100
            count = digit * start * 9;//根据起始数和数位的规律关系找到当前位数所有的值
        }
        // 2.确定n所在的数字是哪一个
        long num = start + (n - 1) / digit; //start是第0个
        // 3.确定n是num中的哪一位数，返回结果
        return Long.toString(num).charAt((n - 1) % digit) - '0'; //String方便根据数位切片
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}