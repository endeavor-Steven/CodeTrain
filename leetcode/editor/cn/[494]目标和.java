package leetcode.editor.cn;
import java.util.*;
//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1284 👎 0

public class TargetSum{
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int count;
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 回溯法
         * 首先观察负号的添加方式有两种，加和减
         * 使用回溯法遍历所有的表达式，进行求和计算比对结果。同时维护一个计算器
         */
        count = 0;
        DFS(nums, target, 0, 0);
    }
    public void DFS(int[] nums, int target, int curr, int sum) {
        if (curr == nums.length) {
            if (sum == target)
                ++count;    //满足条件的情况是，首先长度够，其实结果够
        } else {
            //注意在回溯的时候，sum是变化的
            DFS(nums, target, curr + 1, sum + nums[curr]);
            DFS(nums, target, curr + 1, sum - nums[curr]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}