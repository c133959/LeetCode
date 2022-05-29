package may;

import java.util.Stack;

/**
 1021. 删除最外层的括号
 */
public class RemoveOuterParentheses {

    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);
                if (c == ')'){
                    // 如果是右括号，弹出栈顶'('元素(此时的栈顶元素符合条件的已加入结果集)
                    stack.pop();
                }

                // 入栈前记录结果，如果为空，说明为最外层括号，不加入结果集
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                if (c == '(') {
                    stack.push(c);
                }
            }
            return sb.toString();
        }
    }

}
