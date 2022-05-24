package may;

import java.security.PublicKey;
import java.util.*;

/**
 675. 为高尔夫比赛砍树
 */
public class CutOffTree {
    class Solution {

        // 定义方向数组
        int[][] dirs = {
                {0, 1},{0, -1},{-1, 0},{1, 0}
        };//上下左右

        public int cutOffTree(List<List<Integer>> forest) {

            // 记录数的所在位置
            List<int[]> adj = new ArrayList<>();
            int row = forest.size();
            int col = forest.get(0).size();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (forest.get(i).get(j) > 1) {// 说明该格子为数，记录下标
                        adj.add(new int[] {i,j});
                    }
                }
            }

            Collections.sort(adj,
                    Comparator.comparingInt(a -> forest.get(a[0]).get(a[1]))//按照树的高度排序
            );


            // 主要处理流程
            int cx = 0;
            int cy = 0;
            int steps = 0;
            // 将树按高度排序后，只要依次遍历adj中每个元素的距离，相加即为结果
            for (int i = 0; i < adj.size(); i++) {

                int step = bfs(forest, cx, cy, adj.get(i)[0], adj.get(i)[1]);
                if (step == -1) {
                    return -1;
                }
                steps += step;
                cx = adj.get(i)[0];
                cy = adj.get(i)[1];

            }

            return steps;

        }

        // 广度优先遍历
        int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
            if (sx == tx && sy == ty) {
                return 0;
            }

            // 创建一个visited数组，记忆化搜索
            int row = forest.size();
            int col = forest.get(0).size();
            boolean[][] visited = new boolean[row][col];

            int step = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{sx, sy});//存储当前元素到队列
            visited[sx][sy] = true;

            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //弹出当前元素
                    int[] cell = queue.poll();
                    int cx = cell[0];
                    int cy = cell[1];
                    for (int j = 0; j < 4; j++) {
                        int nx = cx + dirs[j][0];
                        int ny = cy + dirs[j][1];

                        if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                            // 合法坐标，进入
                            if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                                // 是平地或树，可以走
                                if (nx == tx && ny == ty) {
                                    return step;
                                }
                                // 不是目的地，入队并标识
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            // 队列都空了，那么误解
            return -1;

        }
    }
}
