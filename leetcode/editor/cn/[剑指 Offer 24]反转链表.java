package leetcode.editor.cn;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 466 👎 0

public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){this.val = x;}
        ListNode(int x, ListNode p){this.val = x;this.next = p;}
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
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