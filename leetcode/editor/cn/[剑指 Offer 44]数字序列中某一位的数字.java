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
         *      1、数字10，是一个两位数，位数为2，记为digit
         *      2、每个digit位数的起始数字，记为start
         *      3、很多个数字的拼在一起，比如1~9，数位9；10~99，数位180
         *      知道digit和start，有规律；
         *      1、数字的数量 count = digit * 9
         *      2、数位的数量 = start * digit * 9
         *      3、数位的迭代 digit = digit + 1
         * 根据上面的定义，可以判定解题规则
         *      1、确定n所在的数字的位数，记为digit
         *      2、确定n所在的数字，记为num
         *      3、确定n是num中的哪一位数，返回结果
         */
        int digit = 1;      //数位，比如1~9数位是1， 10~99数位为2
        //注意这里的类型，不然会超出的哦
        long start = 1;     //当前digit位数的起始数量，比如1~9起始数为1，10~99起始数为10
        long count = 9;     //当前digit位数一共有多少个数，比如1~9有9个，10~99有180个
        // 1.确定n所在的数字的位数，记为digit
        while (n > count) { //停下来的时候可以来到第n位数字所在的数位，换句话说就知道是几位数了，且知是道起始数开始的第n个数
            n -= count;     //每次用n减去一个数位内的数字数量，一共有n个数，可以用count个数来逼近
            digit += 1;     //每一次位数+1， 比如个位数迭代成十位数再迭代成百位数，每次位数+1
            start *= 10;    //起始数每次*10，比如个位数1迭代成十位数的10再迭代成百位数的100
            count = digit * start * 9;//根据起始数和数位的规律关系找到当前位数所有的值
        }
        // 2.确定n所在的数字，记为num
        //start是第0个
        long num = start + (n - 1) / digit;//(n-1)/digit可以得到，每digit位数组成一个数字的话，第几个数字才是n所在的数字,
        // 3.确定n是num中的哪一位数，返回结果
        //这里的的位数是包含在第几个数内的，数位才是最后的返回
        return Long.toString(num).charAt((n - 1) % digit) - '0'; //获得num的第(n-1)%digit个数位，并转化为int
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}