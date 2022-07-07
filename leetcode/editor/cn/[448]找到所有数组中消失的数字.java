package leetcode.editor.cn;
import java.util.*;
//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 👍 1023 👎 0

public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 法一：Set
         * 用一个HashMap记录nums[i],然后筛查[1, n]中的数是否都有出现。没出现的加入结果
         * 为了优化，可以考虑用长度为N的数组来模拟hashMap，题目提供了一个Nums,尝试是否可以原地修改
         *
         *
         * 法二：优化
         * 遍历枚举， nums[i - 1] + n。因为所有的数的范围是1~n, 所以所有的数都 > n.
         * 二次遍历， nums[i] <= n的就是缺失的数字。
         * 注意，取出来的时候记得取模
         *
         */
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int num : nums) {
            //这是一个映射关系， nums中最多存在1-n, 一共n-1个元素。这种情况下把index用nums[x]来存储
            //所以，虽然不是这种情况，但是通过nums[x]+n的操作可以在二次遍历的时候得到，那些Index是没有被映射到的。
            int x = (num - 1) % len; //把数字还原成索引
            nums[x] += len;
        }
        for (int i = 0 ; i < len ; i++) {
            if (nums[i] <= len)
                ans.add(i + 1); //从索引恢复到数字
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}