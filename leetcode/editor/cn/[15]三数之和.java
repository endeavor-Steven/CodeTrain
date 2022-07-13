package leetcode.editor.cn;
import java.util.*;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4810 👎 0

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 排序+双指针
         *
         * 观察参数，发现长度是可能有问题的  len < 3 , 返回空
         *
         * 对原数组进行排序。然后开始枚举
         * 对于三个指针的位置都要进行重复过滤。遇到一个点i， 使用双指针l = i + 1, r = n - 1;
         * 求和，用划分的思想来移动指针，sum > 0, --r;   sum < 0, ++l
         * 指针在移动的同时记得向前进方向跳过重复值
         * 当枚举到nums[i] > 0的时候就无法出现和为0的情况了，即使剪枝
         */
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return ans;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    //迭代
                    ++left;
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}