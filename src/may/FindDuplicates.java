package may;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindDuplicates
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/8 10:55
 * @Version 1.0
 */
public class FindDuplicates {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            int len = nums.length;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int item = Math.abs(nums[i]);
                if (nums[item - 1] > 0) {
                    nums[item - 1] = -nums[item - 1];
                } else {
                    ans.add(item);
                }
            }
            return ans;
        }
    }
}
