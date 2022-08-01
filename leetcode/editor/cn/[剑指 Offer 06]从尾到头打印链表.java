package leetcode.editor.cn;
import java.util.*;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 320 👎 0

import java.util.ArrayList;

public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {this.val = x;}
        ListNode (int x, ListNode p) {this.val = x;this.next = p;}
    }
    static int[] ans;
    static int curr = 0;
    static int len = 0;
    public int[] reversePrint(ListNode head) {
        /**
         * 递归解法
         * 递归解的优化位置：问题在在于要把list转为int[]有一次开销
         *      可以预定义一个数组同步递归，一个指针用来在递归出口统计长度，一个指针用来作为循环符
         * 力扣在解这种的时候会有报错，但是调试的时候是没有错的
         * @Deprecated 栈解法,效率低于递归
         */
        reverse(head);
        return ans;
    }
    public static void reverse(ListNode head) {
        if (head == null) {
            ans = new int[len];
            return;
        }
        ++len;
        reverse (head.next);
        ans[curr++] = head.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}