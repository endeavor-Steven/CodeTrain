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
         * 思路分析：
         * 原地交换
         * 枚举过程中，遇到一个值x， 把他放到nums[x]中。当第二次遇到x的时候，会有nums[x] = x,此时得到重复值
         * 可能遇到的情况
         *  nums[i] = i, 已经对应了，不管
         *  nums[nums[i]] = nums[i], 表示索引nums[i]处和索引i处的值都是nums[i],也就是一组重复值，返回nums[i];
         *  不满足上述两种情况则交换i和nums[i]的元素值，把数字换到索引的索引位置
         *
         *
         *  （我的理解）
         * 更优的方法：
         * 原地交换（散列映射）————用数组模拟hash的结构出现地址冲突就说明有重复值
         * 我的目的是在初次遍历过程中完成一种散列关系
         * nums[i] = [i];
         * 对每个散列关系进行归位的时候会存在覆盖，为了防止覆盖就交换一下被覆盖的值。依次散列。直到符合关系。
         * 当nums[nums[i]] = nums[i]的时候就意味着已经覆盖过了。（二次跳转都符合关系的话）就是答案了
         */
        int n = nums.length;
        int i = 0;
        while (i < n) {
            //本质的核心是希望构建一个nums[x] = x的映射关系，当二次检索到这种关系的时候就说明是重复值（一对多）。
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                //找到一个值nums[i]他散列的结果还是他本身nums[nums[i]]说明已经排序过了
                return nums[i];
            //目的是把散列占位的值交换出来，避免覆盖
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }


//        /**
//         * Set
//         */
//    public int findRepeatNumber(int[] nums) {
//        int n = nums.length;
//        if (n == 2)
//            return nums[0];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            if (set.contains(nums[i]))
//                return nums[i];
//            else
//                set.add(nums[i]);
//        }
//        return 0;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}