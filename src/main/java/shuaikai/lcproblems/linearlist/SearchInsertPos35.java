package shuaikai.lcproblems.linearlist;

public class SearchInsertPos35 {

	public static int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] > target) {
				r = mid - 1;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5 };

		System.out.println(searchInsert(nums, 7));
	}
}
