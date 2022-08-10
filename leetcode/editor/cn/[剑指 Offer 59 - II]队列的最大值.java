package leetcode.editor.cn;

//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 👍 401 👎 0

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DuiLieDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new DuiLieDeZuiDaZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    /**
     * 我能想到的方法有一个弊端，就是当前面几率过的最大值出队得话怎么办
     * 所以思虑转变为，建立一个递减得列表来保存队列所有递减的元素，递减链表随着入队和出队实时更新。
     * 如此队列最大的元素始终对应递减列表的队首元素。
     * 这个地方的解释：
     *      假设当前队列中的值时5， 1， 3，那么在取最大值5， 3的这个过程中1是不会产生影响的
     *      那么工具队列中的递减元素只要保持5， 3就行了，1其实不会产生作用
     * 实现方法：
     *      当入队时，若入队一个更大的元素，为了保持递减表，将递减表尾部所有小于x的元素弹出
     *      当出队时，若出队的元素时最大的，则递减表需要同时将首元素出队，以保持递减表和队列的元素一致
     */
    Deque<Integer> deque;
    Queue<Integer> que;
    public MaxQueue() {
        deque = new LinkedList<>();
        que = new LinkedList<>();
    }
    
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();//递减队列
    }
    
    public void push_back(int value) {
        que.offer(value);
        while(!deque.isEmpty() && value > deque.peekLast())
            deque.pollLast();
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if (que.isEmpty())
            return -1;
        if (que.peek().equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return que.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}