package leetcode.editor.cn;
import java.util.*;
//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 👍 889 👎 0

public class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        /**
         * 关键审题：
         *      一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
         *
         * 最优解法：原地交换
         *      核心思路：将数组的num存储为index，此时数组变成字典数组（键值关系nums[num] = num）
         *              可以通过搜索下标位置找到值
         *      算法流程：
         *              在枚举过程中，第一次遇到x，调整位置为index = x处，即numx[x] = x;
         *              第二次遇到x时，肯定是已经有了nums[x]=x的，则可判定此时找到了一组重复数
         */
        int n = nums.length;
        int i = 0;
        while (i < n) { //本质的核心是希望构建一个nums[x] = x的映射关系，当二次检索到这种关系的时候就说明是重复值（一对多）。
            if (nums[i] == i) {//此处自然符合排序要求，则准备寻找下一个
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])//此处index的值的归序位置已经有值了
            //nums[i]是准备当前枚举到的值，准备将其从index = i 调整到index = nums[i]的位置，后者的值为nums[nums[i]]。交换重排
                //找到一个值nums[i]他散列的结果还是他本身nums[nums[i]]说明已经排序过了
                return nums[i];
            //又没有天然归序，又不是重复值，则交换index = i 和 index = nums[i]的位置，完成一次归序
            int tmp = nums[i];//注意此处的交换的Index写法，很容易出现覆盖的情况
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}