package Index;

/**
 * @ClassName: FindMedianSortedArrays
 * @Description:
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @Author sunsl
 * @Date 2022/4/30 11:55
 * @Version 1.0
 */
public class FindMedianSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int ALength = A.length, BLength = B.length;//获取数组长度-边界判断，特殊情况判断（长度为0）
            int totalLength = ALength + BLength;//总长度-取总长度中间值即为中位数下标
            if (totalLength % 2 == 1) {
                //是奇数，则只需要找到中间数即可
                int mid = (totalLength + 1) / 2;
                double ret = getNoKItem(A,B,mid);//此处mid为逻辑下标
                return ret;
            } else {
                //是偶数，则应该找到中间位置值之和的平均值(例14个，应该找第7,8个元素中间和-7.5）
                int mid1 = totalLength / 2;
                int mid2 = totalLength / 2 + 1;
                double ret = (getNoKItem(A,B,mid1) + getNoKItem(A,B,mid2) ) / 2.0;//此处mid1,mid2为逻辑下标
                return ret;
            }
        }

        /**
         * 求两个有序数组的第K小的值
         * @param A 数组A
         * @param B 数组B
         * @param k 第K小的元素-为逻辑下标而不是物理下标
         * @return 第K小的元素的值
         */
        double getNoKItem(int[] A, int[] B, int k) {
            int length1 = A.length, length2 = B.length;
            int index1 = 0, index2 = 0;
            int noKItem = 0;
            while (true) {
                // 边界情况
                if (index1 == length1) {
                    // 说明A数组已遍历到尽头，只需要找到B数组index2位置后第k的元素即可(k也在动态变化)
                    return B[index2 + k - 1];
                }
                if (index2 == length2) {
                    // 说明B数组已遍历到尽头，只需要找到A数组index1位置后第k的元素即可
                    return A[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(A[index1], B[index2]);
                }

                //正常处理流程
                int half = k/2;//将K个元素一分为二到A，B两个数组上
                // 找到两个数组中第K/2小的数（直接按照下标找，因为有序），然后比较
                int newIndex1 = Math.min(index1 + half, length1) - 1;//物理下标
                int newIndex2 = Math.min(index2 + half, length2) - 1;//物理下标
                int AItem = A[newIndex1], BItem = B[newIndex2];//获取值
                if (AItem <= BItem) {
                    // 此处A小，则A一直到当前元素不可能为第K小，排除掉（删除，即坐标后移1，同时移除几个，k相应减少几个）
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

