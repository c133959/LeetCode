package getOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: MinStack
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 *
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @Author sunsl
 * @Date 2022/5/2 10:53
 * @Version 1.0
 */
class MinStack {

    Deque<Integer> stack;//普通的栈
    Deque<Integer> minStack;//存储最小值的栈-辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);//存入最大值
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x,minStack.peek()));//存入最小值
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
