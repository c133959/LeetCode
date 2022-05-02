package getOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: CQueue
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/2 10:31
 * @Version 1.0
 */
class CQueue {

    Deque<Integer> inStack;//入栈时存入
    Deque<Integer> outStack;//出栈时将inStack出栈的元素入栈到此

    // 初始化
    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
