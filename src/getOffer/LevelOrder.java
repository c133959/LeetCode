package getOffer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: LevelOrder
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/14 12:41
 * @Version 1.0
 */
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            if(root==null)return new int[0];
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            // 根节点入队
            deque.offer(root);

            // 层次遍历
            while (!deque.isEmpty()) {
                TreeNode head = deque.peek();
                if (head.left != null) {
                    deque.offer(head.left);
                }
                if (head.right != null) {
                    deque.offer(head.right);
                }

                res.add(deque.poll().val);
            }

            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
