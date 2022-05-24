package may;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName: IsUnivalTree
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/24 21:32
 * @Version 1.0
 */
public class IsUnivalTree {
    // 方法一：深度优先算法
    public boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左子树
        if (root.left != null) {
            if (root.val != root.left.val || !dfs(root.left)) {
                return false;
            }
        }
        // 右子树
        if (root.right != null) {
            if (root.val != root.right.val || !dfs(root.right)) {
                return false;
            }
        }
        return true;
    }

    //方法二：广度优先遍历算法
    public boolean bfs(TreeNode root) {

        if (root == null) {
            return true;
        }
        int val = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                if (node.left.val != val) {
                    return false;
                }
            }

            if (node.right != null) {
                queue.offer(node.right);
                if (node.right.val != val) {
                    return false;
                }
            }
        }
        return true;

    }


}
