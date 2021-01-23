package leetcode;

/**
 * Basic Idea: If we divide the array into two parts with equal length and right
 * part is always greater than the left part. so median is (max(left_part) +
 * min(right_part)) / 2
 * 
 * Binary search to find the partition
 * 
 * Since A has m elements, so there are m+1 kinds of cutting( i = 0 ~ m ) . And
 * we know: len(left_A) = i, len(right_A) = m - i . Note: when i = 0 , left_A is
 * empty, and when i = m , right_A is empty.
 * 
 * @author leen
 *
 */
public class _0004_MedianTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		// Make sure length of nums1 is smaller than nums2
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int left = 0, right = m;
		while (left <= right) {
			int partitionX = left + (right - left) / 2;
			// If m + n is even, then split the elements evenly into the left and right
			// part, so i + j = m + n - i - j. Thus j = (m + n)/2 -i
			// If m + n is odd, then put the median in the left part,
			// so the number of elements in the left part is one more than that of elements
			// in the right part.
			// That's where + 1 comes in the formula: i + j = m + n - i - j + 1 => thus j =
			// (m + n + 1)/2 - i
			// num is even, then num/2 = (num + 1)/2, for example 4/2 = (4 + 1)/2 = 2.
			// So (m + n)/2 is equal to (m + n + 1)/2
			int partitionY = (m + n + 1) / 2 - partitionX;
			// nums1 maxLeftX minRightX
			// nums2 maxLeftY minRightY
			// since nums1 is sorted: maxLeftX <= minRightX but we need maxLeftX <=
			// minRightY
			// since nums2 is sorted: maxLeftY <= minRightY but we need maxLeftY <=
			// minRightX
			// if partitionX is 0 it means nothing is there on left side. Use -INF for
			// maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use
			// +INF for minRightX
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];

			// get max of left for odd length combined array size.
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((m + n) % 2 == 0) {
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}

			} else if (maxLeftX > minRightY) {
				// 1 3 5 | 7
				// 2 |4 6 8
				right = partitionX - 1;

			} else {
				left = partitionX + 1;
			}

		}
		return 0.0;
	}
}
