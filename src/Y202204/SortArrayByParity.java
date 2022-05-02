package Y202204;

/**
 * @ClassName: SortArrayByParity
 * @Description: 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * @Author sunsl
 * @Date 2022/4/28 22:13
 * @Version 1.0
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3};
        solution.sortArrayByParity(nums);
    }
    static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            // 使用首尾指针，指向首节点和尾结点，然后依次前移、后移
            int head = 0;
            int tail = nums.length - 1;
            while (head < tail) {
                // 头指针指向奇数时停止，尾指针指向偶数时停止
                while (isParity(nums[head]) && head < nums.length - 1 && head < tail) {
                    head++;
                }
                while (!isParity(nums[tail]) && tail >= 0 && head < tail) {
                    tail--;
                }
                // 交换
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
            return nums;
        }
        // true偶数 FALSE奇数
        boolean isParity(int num) {
            return num % 2 == 0;
        }
    }
}
