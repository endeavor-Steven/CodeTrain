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

public class MinStack{
    public static void main(String[] args) {
        Solution solution = new MinStack().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
//    /**
//     * 法一：辅助栈
//     */
//    Deque<Integer> stack;
//    Deque<Integer> MinStack;
//    public MinStack() {
//        stack = new LinkedList<Integer>();
//        MinStack = new LinkedList<Integer>();
////        MinStack.push(Integer.MAX_VALUE);//这一步操作对应的是每次取最小的放进去
//    }
//
//    public void push(int val) {
//        stack.push(val);
////        MinStack.push(Math.min(MinStack.peek(), val));//当前这个位置的最小值。使用这种方法，在弹出时就要每次弹出
//        if (MinStack.isEmpty() || MinStack.peek() >= val) {
//            MinStack.push(val);
//        }
//    }
//
//    public void pop() {
//        if(stack.pop().equals(MinStack.peek()))
//            MinStack.pop();
////        stack.pop();
////        MinStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return MinStack.peek();
//    }

    /**
     * 法二，只使用一个栈
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