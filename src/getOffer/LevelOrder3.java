package getOffer;

import java.util.*;

/**
 * @ClassName: LevelOrder3
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/14 13:20
 * @Version 1.0
 */
public class LevelOrder3 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            Boolean ascTag = true;

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
                ascTag = !ascTag;// 每层交替
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
                    if (!ascTag) {
                        Collections.reverse(list);
                    }
                    res.add(list);
                }
            }

            return res;
        }
    }

}
