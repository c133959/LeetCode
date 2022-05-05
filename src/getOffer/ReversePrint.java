package getOffer;

import java.util.List;

/**
 * @ClassName: ReversePrint
 * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @Author sunsl
 * @Date 2022/5/5 21:02
 * @Version 1.0
 */

public class ReversePrint {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode listNode = new Solution.ListNode(1);
        Solution.ListNode listNode1 = new Solution.ListNode(3);
        Solution.ListNode listNode2 = new Solution.ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        solution.reversePrint(listNode);
    }
    static class Solution {
        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[]{};
            }
            int size = 1;
            ListNode p = head.next;
            head.next = null;//切断指针
            while (p != null) {
                size++;
                ListNode temp = p;
                p = p.next;

                temp.next = head;
                head = temp;
            }
            //定义一个数组
            int[] res = new int[size];
            p = head;
            int i = 0;
            while (p != null) {
                res[i++] = p.val;
                p = p.next;
            }
            return res;
        }
    }
}
