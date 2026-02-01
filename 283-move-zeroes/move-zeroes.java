class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;

        // Move all non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }

        // Fill the rest with zeros
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
