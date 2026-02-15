import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Process nums2
        for (int num : nums2) {
            
            // Find next greater for stack elements
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            
            stack.push(num);
        }
        
        // Remaining elements → no greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        
        // Build answer for nums1
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}
