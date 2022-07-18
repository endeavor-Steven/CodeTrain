package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2037 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *排列和组合都要使用回溯法
     *
     * 排列的话还要使用一个额外的数组来标识是否使用过
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(ans, tmp, 0, nums, used);
        return  ans;
    }
    public static void backtrack(List<List<Integer>> ans, List<Integer> tmp, int curr, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {//这个地方采用curr == nums.length,那么下面对应的回溯条件就是curr+1
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                tmp.add(nums[i]);
                used[i] = true;
                backtrack(ans, tmp, i + 1, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}