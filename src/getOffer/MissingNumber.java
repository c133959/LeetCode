package getOffer;

/**
 * @ClassName: MissingNumber
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/8 19:58
 * @Version 1.0
 */
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
