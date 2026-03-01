import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Build graph: graph[node][color]
        List<Integer>[][] graph = new ArrayList[n][2];
        
        for (int i = 0; i < n; i++) {
            graph[i][0] = new ArrayList<>(); // red
            graph[i][1] = new ArrayList<>(); // blue
        }
        
        for (int[] e : redEdges)
            graph[e[0]][0].add(e[1]);
        
        for (int[] e : blueEdges)
            graph[e[0]][1].add(e[1]);
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        
        // Start with both colors
        queue.offer(new int[]{0, 0}); // came via red
        queue.offer(new int[]{0, 1}); // came via blue
        visited[0][0] = true;
        visited[0][1] = true;
        
        int distance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];
                
                if (result[node] == -1)
                    result[node] = distance;
                
                // Switch color (alternate)
                int nextColor = 1 - color;
                
                for (int neighbor : graph[node][nextColor]) {
                    if (!visited[neighbor][nextColor]) {
                        visited[neighbor][nextColor] = true;
                        queue.offer(new int[]{neighbor, nextColor});
                    }
                }
            }
            
            distance++;
        }
        
        return result;
    }
}
