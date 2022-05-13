package may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: MinMutation
 * @Description: 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使start 变化为 end 所需的最少变化次数。
 *
 * 如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * @Author sunsl
 * @Date 2022/5/7 16:58
 * @Version 1.0
 */
public class MinMutation {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            int startLen = start.length();
            int bankSize = bank.length;
            //邻接表
            List<Integer>[] adj = new List[bankSize];//存储bank中可以一次变化得来的基因序列
            // *初始化
            for (int i = 0; i < bankSize; i++) {
                adj[i] = new ArrayList<>();
            }

            // *构建邻接表-预处理bank中所有可以一次性转换的基因序列
            int endIndex = -1;//目标基因序列所在bank中的坐标
            for (int i = 0; i < bankSize; i++) {
                if (end.equals(bank[i])) {
                    endIndex = i;
                }

                // 找到bank中与当前基于序列 可以一次变化得到的 其他基因序列 加入邻接表
                for (int j = i+1; j < bankSize; j++) {
                    int diff = 0;//存储两基因序列不同的序列数量
                    for (int k = 0; k < startLen; k++) {
                        if (bank[i].charAt(k) != bank[j].charAt(k)) {
                            diff++;
                        }
                        if (diff > 1) {
                            break;// 如果不是可以通过一步到达，则不属于邻接关系，直接跳出循环
                        }
                    }
                    if (diff == 1) {
                        // 如果是邻接关系，则加到表中
                        adj[i].add(j);
                        adj[j].add(i);
                    }

                }
            }
            if (endIndex == -1) {
                return -1;
            }

            // *初始化队列-入队start距离为1的基因序列
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[bankSize];
            int step = 1;
            for (int i = 0; i < bankSize; i++) {
                int diff = 0;
                for (int j = 0; j < startLen; j++) {
                    if (start.charAt(j) != bank[i].charAt(j)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    queue.offer(i);//入队bank中的某一项，该项与start的距离为1
                    visited[i] = true;//已加入，防止重复遍历
                }
            }

            // *广度优先遍历
            while (!queue.isEmpty()) {
                //初始状态中所有的内容为距离start为1的基因序列
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int currItem = queue.poll();//出队
                    if (currItem == endIndex) {
                        return step;
                    }
                    // 找到出队元素的相邻节点 入队
                    for (Integer neighbor : adj[currItem]) {
                        if (visited[neighbor])
                            continue;//如果已遍历过，则跳过
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
                step++;//如果这一层没有找到，step++
            }

            return -1;
        }
    }
}
