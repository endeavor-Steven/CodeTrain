package leetcode.editor.cn;
import java.util.*;
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1470 👎 0

import java.util.Arrays;

public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /**
         * BM投票算法
         * 维护一个候选众数 candidate 和它出现的次数 count。
         *      初始时 candidate 可以为任意值，count 为 0；
         *
         * 投票算法证明：
         * 如果候选人不是maj 则 maj,会和其他非候选人一起反对(--count) 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
         * 如果候选人是maj , 则maj 会支持自己(++count)，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
         *
         */
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (candidate == num)
                ++count;
            else
                --count;
        }
        return candidate;

        //法二：哈希表
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }
//        }
//        Map.Entry<Integer, Integer> ansEntry = null;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (ansEntry == null || entry.getValue() > ansEntry.getValue())
//                ansEntry = entry;
//        }
//        return ansEntry.getKey();

        //法一：排序
//        Arrays.sort(nums);
//        return nums[nums.length / 2];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}