class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ma =0,l=0,r= n-1;
        while(l <=r){
            int h = Math.min(height[l],height[r]);
            int w = r -l;
            int area = h * w;
            ma = Math.max(ma,area);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
return ma;
        
    }
}