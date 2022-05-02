package Y202204;

import java.util.Arrays;

/**
 * @ClassName: MaximumWealth
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/4/14 19:57
 * @Version 1.0
 */
public class MaximumWealth {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int maxWealth = Integer.MIN_VALUE;
            for (int[] account :
                    accounts) {
                maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());

            }
            return maxWealth;
        }
    }
}
