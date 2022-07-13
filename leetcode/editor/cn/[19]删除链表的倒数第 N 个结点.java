package leetcode.editor.cn;
import java.util.*;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2056 👎 0

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 思路，快慢指针
         * 需要倒数几个，就把快指针放在慢指针前面多少个。
         * 比如导数第二个。那么就用让快指针从头节点往前走两步，然后二者等步往后，快指针到表尾的时候，慢指针指的就是导数第二个
         * 同时由于是删除导数第三个，其实真实是要找到倒数第四个
         *
         * 1、找到倒数n+1个节点位置
         * 2、方便处理要加上头节点，首位节点就好处理了。返回的时候也是头节点.next
         */
        ListNode dummyhead = new ListNode(0, head);//构建一个头节点
        ListNode slow = dummyhead, fast = slow;
        int count = 0;
        while (count != n + 1) {
            fast = fast.next;
            ++count;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
}
//leetcode submit region end(Prohibit modification and deletion)

}