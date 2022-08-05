package leetcode.editor.cn;
import java.util.*;
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// 
// Related Topics 哈希表 链表 👍 570 👎 0

public class FuZaLianBiaoDeFuZhiLcof{
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
     * 这个题目要做深拷贝，但是问题在于，在迭代复制random指针的时候可能还没有创建出来
     * 本题难点： 在复制链表的过程中构建新链表各节点的 random 引用指向。
     *
     *
     */
    public Node copyRandomList(Node head) {
        if (head == null)  return null;

        Node p = head;  //遍历指针
        Map<Node, Node> map = new HashMap<>(); //NodeOld -> NodeNew
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}