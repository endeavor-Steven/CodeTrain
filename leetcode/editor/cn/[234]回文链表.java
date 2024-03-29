package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1424 👎 0

import java.util.List;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
    public boolean isPalindrome(ListNode head) {
    /**
     * 时间n， 空间1
     * 1找到前半部分链表的尾节点。使用快慢指针
     * 2反转后半部分链表。
     * 3判断是否回文。
     * 4恢复链表。如果不考虑还可以更快，但是题目只是说让判断
     * 5返回结果。
     *
     * 还有一种解法性能会更好一点，就是在找中点的过程中迭代逆序前面半截
     */
        if (head.next == null)
            return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }//结束的时候s，的后半截翻转
        slow = slow.next;//从后面一个节点开始嘛
        slow = reverse(slow);
        ListNode pre = head;
        while (slow != null) {
            if (pre.val != slow.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(0, null);
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = dummyHead.next;
            dummyHead.next = tmp;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}