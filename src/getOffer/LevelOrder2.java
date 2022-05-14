package getOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: LevelOrder2
 * @Description:
 * @Author sunsl
 * @Date 2022/5/14 13:00
 * @Version 1.0
 */
public class LevelOrder2 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();

            if (root == null) {
                return res;
            }
            // 第一层数组 & 根节点入队
            deque.offer(root);
            List<Integer> rootList = new ArrayList<>();
            rootList.add(root.val);
            res.add(rootList);

            // 层次遍历
            while (!deque.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = deque.size();
                // 一层的全部遍历到，所以要加入循环
                for (int i = 0; i < size; i++) {
                    TreeNode peek = deque.poll();
                    if (peek.left != null) {
                        deque.offer(peek.left);
                        list.add(peek.left.val);
                    }
                    if (peek.right != null) {
                        deque.offer(peek.right);
                        list.add(peek.right.val);
                    }
                }

                if (!list.isEmpty()) {
                    res.add(list);
                }
            }

            return res;
        }
    }
}
