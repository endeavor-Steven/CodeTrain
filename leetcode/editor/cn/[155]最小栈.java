package leetcode.editor.cn;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
// Related Topics 栈 设计 👍 1337 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        /**
         * 法一：双栈
         * 同步主栈保存一个最小栈。顶部始终是当前最小值
         */
//    Deque<Integer> s;
//    Deque<Integer> sMin;
//    public MinStack() {
//        s = new LinkedList<>();
//        sMin = new LinkedList<>();
//        sMin.push(Integer.MAX_VALUE);
//    }
//    public void push(int val) {
//        s.push(val);
//        sMin.push(Math.min(sMin.peek(), val));
//    }
//    public void pop() {
//        s.pop();
//        sMin.pop();
//    }
//    public int top() {
//        return s.peek();
//    }
//    public int getMin() {
//        return sMin.peek();
//    }

    /**
     * 法二，数组栈（单栈）
     * 基本元素int[] -->> [当前值, s当前最小值]
     * 同时保存，每个数字x入栈时的值 和 插入x时的最小值。换句话说存进去的是一对值
     */
    private Deque<int[]> s;
    public MinStack() {
        s = new LinkedList<>();
    }
    public void push(int x) {
        if (s.isEmpty()) {
            s.push(new int[]{x, x});
        } else {
            s.push(new int[]{x, Math.min(s.peek()[1], x)});
        }
    }
    public void pop() {
        s.pop();
    }
    public int top() {
        return s.peek()[0];
    }
    public int getMin() {
        return s.peek()[1];
    }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}