import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            
            // While current temp is greater
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) {
                
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
