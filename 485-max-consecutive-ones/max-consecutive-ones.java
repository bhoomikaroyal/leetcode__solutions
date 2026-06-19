class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cc =0;
        int maxx =0;
        for(int j =0;j<n;j++){
            if(nums[j] == 1){
                cc++;

            }else{
                maxx = Math.max(maxx,cc);
                cc =0;
            }
        }
        return Math.max(maxx,cc);
        }
    }
