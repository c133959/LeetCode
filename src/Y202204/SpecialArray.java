package Y202204;

import java.util.Arrays;

public class SpecialArray {
    class Solution {
        public int specialArray(int[] nums) {
            int len = nums.length;
            // 对数组进行排序，然后进行二分法
            Arrays.sort(nums);
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (sumArray(nums, mid) == mid) {
                    return mid;
                } else if(sumArray(nums, mid) > mid) {
                    left = mid + 1;
                } else {
                    right = mid + 1;
                }
            }
            return -1;
        }
        int sumArray(int[] nums, int target) {
            //>=target的数量
            int len = nums.length;
            if (nums[0] >= target) {
                return len;
            }
            int right = nums.length;
            int left = 0;
            while (left < right) {
                // 找到第一个比target小的数 下标
                int mid = (right - left) / 2 + left;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return len - (left + 1);
        }
    }
}
