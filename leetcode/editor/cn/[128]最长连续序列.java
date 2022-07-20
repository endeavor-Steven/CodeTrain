package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1288 👎 0

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        /**
         * 原始思路：枚举每个值x，分别判断x+1, x+2, x+3， x+n是否存在,存在则长度为n+1。
         *      存在大量的重复判断，可以使用哈希表加速查找，以及剪枝避免重复判断
         * 优化思路：优化枚举的每个点的搜索时间，同时对新的点判断其前面一个点是否连续(剪枝)，
         *      连续就不管，不连续的话就开始往后面查找
         */
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) { //前面一个数不连续则继续
                int tmpLen = 1;
                int num = i;//准备以num为左边界进行探索
                while (set.contains(num + 1)) {
                    ++num;
                    ++tmpLen;
                }
                ans = Math.max(ans, tmpLen);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}