package leetcode;

public class _0912_SortArray {
	public int[] sortArray(int[] nums) {
		mergesort(nums, 0, nums.length - 1, new int[nums.length]);
		return nums;
	}

	public int[] sortArry_quick(int[] nums) {
		quicksort(nums, 0, nums.length - 1);
		return nums;
	}

	private void mergesort(int[] nums, int start, int end, int[] temp) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		mergesort(nums, start, mid, temp);
		mergesort(nums, mid + 1, end, temp);
		merge(nums, start, mid, end, temp);
	}

	private void merge(int[] nums, int start, int mid, int end, int[] temp) {
		int left = start, right = mid + 1;
		int index = start;
		while (left <= mid && right <= end) {
			if (nums[left] <= nums[right]) {
				temp[index++] = nums[left++];
			} else {
				temp[index++] = nums[right++];
			}
		}
		while (left <= mid) {
			temp[index++] = nums[left++];
		}
		while (right <= end) {
			temp[index++] = nums[right++];
		}
		for (int i = start; i <= end; i++) {
			nums[i] = temp[i];
		}
	}

	private void quicksort(int[] nums, int start, int end) {
		if (start >= end)
			return;
		int left = start, right = end;
		int pivot = nums[start + (right - start) / 2];
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
		quicksort(nums, start, right);
		quicksort(nums, left, end);
	}

}
