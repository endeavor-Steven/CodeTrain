package leetcode.editor.cn;
import java.util.*;
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 517 👎 0

import java.util.Arrays;

public class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        /**
         * 要求拼接起来的两个字符串代表的数字，巴拉巴拉巴拉这是一个排序题，结论如下
         *      x + y > y + x  ==>  x > y
         *      x + y < y + x  ==>  x < y
         *      这就意味着，如果x小于y，排序完成之后，在数组中x应该在y的左边；
         *                如果x大于y，排序完成之后，在数组中x应该在y的右边。
         *
         *  算法流程，
         *      根据上面的排序规则，进行排序，然后拼接
         */
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y)->(x+y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for(String str : strs)
            res.append(str);
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}