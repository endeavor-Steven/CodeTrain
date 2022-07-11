package leetcode.editor.cn;
import java.util.*;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 8116 👎 0

public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //链表节点的定义
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思路分析：
         * 逆序存储
         * 逐位相加之后，可能会遇到要进位的情况
         */
        ListNode ans = new ListNode();          //第一个节点
        ListNode dummyHead = ans;    //头节点
        int sum = 0;                            //进位符号，也可以用来存储第一位
        while (l1 != null || l2 != null) {
            sum += l1.val + l2.val;
            ListNode tmp = new ListNode(sum % 10);//新节点的值应该是只存储sum的个位数，十位数给下一节
            sum /= 10;                         //保留十位作为进位
            ans.next = tmp;

            ans = ans.next;                     //迭代
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum += l1.val;
            ListNode tmp = new ListNode(sum % 10);
            sum /= 10;
            ans.next = tmp;
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum += l2.val;
            ListNode tmp = new ListNode(sum % 10);
            sum /= 10;
            ans.next = tmp;
            ans = ans.next;
            l2 = l2.next;
        }
        if (sum != 0) {
            ListNode tmp = new ListNode(sum);
            ans.next = tmp;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}



//    Solution.ListNode ans = new Solution.ListNode(0);
//    Solution.ListNode rear = ans;
//    int carry = 0;
//
//        while (l1 != null || l2 != null) {
//                int val1 = l1 == null ? 0 : l1.val;
//                int val2 = l2 == null ? 0 : l2.val;
//                int sum = val1 + val2 + carry; //取出相加位
//
//                carry = sum / 10;
//                sum %= 10;
//
//                ListNode tmp = new ListNode(sum);
//                rear.next = tmp;
//
//                if (l1 != null) l1 = l1.next;
//                if (l2 != null) l2 = l2.next;//迭代
//                }
//                if (carry == 1) rear.next = new ListNode(carry);
//                return ans.next;