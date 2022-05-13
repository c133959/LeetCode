package may;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RecentCounter
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/6 10:57
 * @Version 1.0
 */
public class RecentCounter {

    private int j = 0;//滑动窗口左区间
    private int requestNum = 0;
    List<Integer> requests = new ArrayList<>();


    //初始化计数器，请求数为 0
    public RecentCounter() {
        j = 0;
        requestNum = 0;
        requests.clear();
    }

    /**
     * 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
     * 确切地说，返回在 [t-3000, t] 内发生的请求数。
     */
    public int ping(int t) {
        // 新请求加入列表
        requests.add(t);
        int len = requests.size();
        while (j < len) {
            // 如果属于过期请求，则左区间右移（特别的，当仅有一个请求时，t < t-3000必然为false;
            // 当j指向最后一个元素时（即为最新元素，也必然为false，所以j永远不会到达边界,len-j永远>=1
            if (requests.get(j) < t - 3000) {
                j++;
            } else {
                // 如果当前
                break;
            }
        }
        requestNum = len - j;
        return requestNum;
    }
}
