package leetcode.editor.cn;
import java.util.*;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numbers = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == numbers.length 
// 1 <= n <= 5000 
// -5000 <= numbers[i] <= 5000 
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 672 👎 0

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        /**
         * 二分查找
         * 思路解析：要认识到一个数组的末位nums[len-1]的意义。旋转中心可以看成两个点，除了最小值那个点,就是这个点。
         *      最小值的左边肯定都是大于等于这个点的；最小值的右边肯定都是小于等于这个点的。
         *      要利用这个特性来判断二分位置
         * 取左右端点和取中点判断会有三种情况：
         *      1、nums[mid] < nums[right], 此时中点落在右半侧，可以抛弃右半侧
         *      2、nums[mid] > nums[right], 此时中点落在左半侧，可以抛弃左半侧
         *      3、nums[mid] = nums[right], 由于可能有重复值所以无法判断最小值的方向，
         *          这个时候右端点左移一位（此时即使此点是最低点左移了也不打紧，因为重复了），迭代判断
         *      4、nums[left]就是最后的出口
         */
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[right])//忽略右边，
                right = mid;    //和下面一套理解，此时右边是正常的数组，迭代的时候要保守一点避免往左掉进了异常数组
            else if ((numbers[mid] > numbers[right]))//忽略左边，
                left = mid + 1;//一种理解：此时左边是异常数组，竟然中点比最右大（不是正常的），我此时的目的是跳出异常数组
            else
                --right;
        }
        return numbers[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}