package may;

/**
 * @ClassName: NumSubarrayProductLessThanK
 * @Description: 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * @Author sunsl
 * @Date 2022/5/5 20:51
 * @Version 1.0
 */
public class NumSubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int len = nums.length,
            res = 0;
            int prod = 1;
            int j = 0;
            for (int i = 0; i < len; i++) {
                prod *= nums[i];
                // 不是目标区间，右移左区间
                while (j <= i && prod >= k) {
                    prod /= nums[j];
                    j++;
                }
                res += i - j + 1;
            }
            return res;
        }
    }
}
