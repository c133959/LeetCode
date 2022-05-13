package getOffer;

/**
 * @ClassName: Search
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/8 19:28
 * @Version 1.0
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false) - 1;
            if (left <= right
                    && left < nums.length
                    && nums[left] == target
                    && nums[right] == target) {
                return right - left + 1;
            }
            return 0;
        }
        public int binarySearch(int nums[], int target, boolean lower) {
            int left = 0;
            int right = nums.length - 1;
            int ans = nums.length;

            // 二分查找
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] > target // 找右边界
                    || (lower && nums[mid] >= target)) { // 找左边界
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }

            return ans;

        }
    }
}
