package leetcode.editor.cn;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1802 👎 0

public class FindTheDuplicateNumber{
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        /**
         * 快慢指针
         * 模仿龟兔赛跑
         * 核心思路是：如何把数组变成链表的形式
         * 举例说明
         * nums[]{1, 3, 4, 2}
         *  index->value:0->1, 1->3, 2->4, 3->2;
         *  链表：0->1->3->2->4;这个链表中是没有产生环的
         * 如果存在重复的数，则映射成的链表会有一对多的关系，即产生环
         * 这样就转换成了一个判断链表中是否有环的问题了
         * 这里注意，慢指针走一步，快指针走两步
         */
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //找到相交点之后，根据数学关系，重取一个从零开始的点，和slow同步距往后走会在环处相遇
        int ans = 0;
        while (ans != slow) {
            ans = nums[ans];
            slow = nums[slow];
        }
        return ans;




//        //可以，但是超时了
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j] && i != j) {
//                    ++count;
//                }
//                if (count == 1) {
//                    ans = nums[i];
//                }
//            }
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}