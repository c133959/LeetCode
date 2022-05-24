package may;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RepeatedNTimes
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/24 22:05
 * @Version 1.0
 */
public class RepeatedNTimes {
    class Solution {
        public int repeatedNTimes(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)){
                    return num;
                } else {
                    map.put(num, num);
                }
            }
            return -1;
        }
    }
}
