package leetcode;

//You can iterate over the array and keep track of the minimum prefix sums you’ve encountered, 

//The maximum subarray that ends at index i, is the prefix sum at i, minus the minimum prefix sum before i.

//If we can find all the maximum subarray that end at index 0, 1, 2, ...., we take the maximum of them,
//which is the maximum subarray of the input array.

public class _0053_MaximumSubarray {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int curSum = 0;
		int minSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			maxSum = Math.max(maxSum, curSum - minSum);
			minSum = Math.min(minSum, curSum);
		}
		return maxSum;
	}
}
