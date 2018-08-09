package day08_SegmentTree;

class NumArray303_2 {
	private int[] sum;

	public NumArray303_2(int[] nums) {
		sum = new int[nums.length + 1];
		sum[0]=0;
		for (int i = 1; i < sum.length; i++) {
			sum[i]=sum[i-1]+nums[i-1];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j+1] -sum[i];
	}
}

/**
 * Your NumArray303 object will be instantiated and called as such:
 * NumArray303 obj = new NumArray303(nums);
 * int param_1 = obj.sumRange(i,j);
 */