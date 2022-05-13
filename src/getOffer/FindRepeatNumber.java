package getOffer;

/**
 * @ClassName: FindRepeatNumber
 * @Description: 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 *
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @Author sunsl
 * @Date 2022/5/8 16:31
 * @Version 1.0
 */
public class FindRepeatNumber {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int item = Math.abs(nums[i]);
                if (nums[item] > 0) {
                    nums[item] = -nums[item];
                } else {
                    return item;
                }
            }
            return 0;
        }
    }
}
