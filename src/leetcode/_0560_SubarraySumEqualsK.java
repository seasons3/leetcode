package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://aaronice.gitbook.io/lintcode/array/subarray-sum-equals-k
 * 1) Naive solution: find all possible sub-arrays. check sum of each sub-array
 * equals k
 * 
 * 2) using prefix sum to calculate sub-array sum
 * 
 * 3) sum(i, j) = prefixsum[j+1] - prefixsum[i];
 any time we get to a point where sum-k is a previous sum (say at index i), we know that the sum between index i and our current index is exactly k.
 * Find how many pairs i,j such that i<j prefixsum[j] - prefixsum[i] = k 
 * for each j how many i<j satisfies
 * prefixsum[i] = prefixsum[j] - k; 
 * using HashMap to store prefixsum gitbook.io/lintcode/array/subarray-sum-equals-k
 * 1) Naive solution: find all possible sub-arrays. check sum of each sub-array
 * equals k
 * 
 * 2) using prefix sum to calculate sub-array sum
 * 
 * 3) sum(i, j) = prefixsum[j+1] - prefixsum[i];
 any time we get to a point where sum-k is a previous sum (say at index i), we know that the sum between index i and our current index is exactly k.
 * Find how many pairs i,j such that i<j prefixsum[j] - prefixsum[i] = k 
 * for each j how many i<j satisfies
 * prefixsum[
 * key  prefixsum value 
 * value number of occurance 
 * nums = [1, 1, 1] index: 0, 1, 2
 * prefix sum: 0 1, 2, 3 
 *                  j Assume k =2, only needs to know how many 0 before j
 * 
 * @author leen
 *
 */
public class _0560_SubarraySumEqualsK {

	// Native solution
	public int subarraySum1(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++)
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				// repeat can use prefix sum
				for (int index = i; index <= j; index++) {
					sum += nums[index];
					if (sum == k) {
						count++;
					}
				}
			}
		return count;

	}
	// nums = [1, 1, 1]
	// index: 0, 1, 2

// prefix sum:0 1, 2, 3
// sum(i, j) = prefixsum(j+1) - prefixsum(j)

	public int subarraySum2(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int prefixsum = 0;
			for (int j = i; j < nums.length; j++) {
				prefixsum += nums[j];
				// repeat
				if (prefixsum == k) {
					count++;
				}

			}
		}
		return count;

	}

	public int subarraySum3(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		//要加入 {0,1} 这对映射，这是为啥呢，因为我们的解题思路是遍历数组中的数字，用 sum 来记录到当前位置的累加和，我们建立哈希表的目的是为了让我们可以快速的查找 sum-k 是否存在，即是否有连续子数组的和为 sum-k，如果存在的话，那么和为k的子数组一定也存在，这样当 sum 刚好为k的时候，那么数组从起始到当前位置的这段子数组的和就是k，满足题意，如果哈希表中事先没有 m[0] 项的话，这个符合题意的结果就无法累加到结果 res 中，这就是初始化的用途
		// map.put(0, 1);
		int prefixsum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			//sum all the elements(find cumulative sum) upto index i, store it in sum
			prefixsum += nums[i];
			count += map.getOrDefault(prefixsum - k, 0);
			map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
		}
		return count;

	}

}
