package Y202204;

import java.util.Arrays;

/**
 * @ClassName: SmallestRangeI
 * @Description: 最小差值 I
 * 给你一个整数数组 nums，和一个整数 k 。
 *
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。
 * 将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 *
 * nums的分数是nums中最大和最小元素的差值。
 *
 * 在对 nums 中的每个索引最多应用一次上述操作后，返回nums 的最低 分数 。

 * @Author sunsl
 * @Date 2022/4/30 11:22
 * @Version 1.0
 */
public class SmallestRangeI {
    class Solution {
        public int smallestRangeI(int[] nums, int k) {
            // 获取数组中的最大值和最小值
            int max = Arrays.stream(nums).max().getAsInt();
            int min = Arrays.stream(nums).min().getAsInt();
            if (max - min <= 2 * k) {
                //当最大值和最小值可以通过[-k,k]之间运算相等时，说明差值可以为0
                return 0;
            } else {
                // 否则，则尽可能的取差值，即可
                return max-min-2*k;
            }
        }
    }
}
