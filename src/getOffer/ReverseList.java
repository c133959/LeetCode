package getOffer;

import java.util.List;

/**
 * @ClassName: ReverseList
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/5 21:30
 * @Version 1.0
 */
public class ReverseList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode p = head.next;
            head.next = null;
            while (p != null) {
                ListNode temp = p;
                p = p.next;

                temp.next = head;
                head = temp;
            }
            return head;
        }
    }
}
