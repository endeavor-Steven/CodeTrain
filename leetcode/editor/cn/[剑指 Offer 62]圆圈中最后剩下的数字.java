package leetcode.editor.cn;

//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 656 👎 0

import java.util.ArrayList;
import java.util.List;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        /**
         * 本质上是动态规划，但是我有点看不懂，我们姑且用给找规律的方法来理解
         * 我们观察最后一次删除的情况，此时数组内只有两个元素，再删除一个就只剩下最后一个了。
         * 我们可以逆转这个过程，从而推理出最后剩余的这个元素在原始序列中的位置
         * 反转的规律总结一下大概就是
         *      上一层删除时前最终元素的位置 = (这一层的索引位置 + m ) % 上一层的数组长度
         *      这是一个逆置恢复的操作
         *
         * 具体的算法流程可以这里开始，模拟执行最后一次删除的时候的长度开始，
         */
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}