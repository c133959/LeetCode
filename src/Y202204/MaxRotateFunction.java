package Y202204;

import java.util.Arrays;

/**
 * @ClassName: MaxRotateFunction
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/4/22 22:10
 * @Version 1.0
 */
public class MaxRotateFunction {
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int f = 0, len = nums.length, sum = Arrays.stream(nums).sum();
            for (int i = 0; i < len; i++) {
                f += i * nums[i];
            }
            int res = f;
            for (int i = len - 1; i > 0 ; i--) {
                f += sum - len * nums[i];
                res = Math.max(res,f);
            }
            return res;
        }
    }
}
