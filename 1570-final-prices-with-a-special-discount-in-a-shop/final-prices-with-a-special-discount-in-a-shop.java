import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;
        int[] result = prices.clone(); // copy original
        
        Stack<Integer> stack = new Stack<>(); // store indices
        
        for (int i = 0; i < n; i++) {
            
            // Apply discount
            while (!stack.isEmpty() && 
                   prices[i] <= prices[stack.peek()]) {
                
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            
            stack.push(i);
        }
        
        return result;
    }
}
