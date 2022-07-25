package leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2592 👎 0

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        
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
        ListNode() {}
        ListNode(int x) {this.val = x;}
        ListNode(int x, ListNode node) {this.val = x; this.next = node}
    }
    public ListNode reverseList(ListNode head) {
        //递归
//        if (head == null || head.next == null) return head;
//        ListNode dummyNode = new ListNode(0, null);
//        while (head != null) {
//            ListNode tmp = head;
//            head = head.next;
//            tmp.next = dummyNode.next;
//            dummyNode.next = tmp;
//        }
//        return dummyNode.next;

        //迭代--最优解
        //取一个pre指向前面的节点，取一个tmp保留后面的节点，然后每次Ⅹcurr.next = pre，然后更新各个指针
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}