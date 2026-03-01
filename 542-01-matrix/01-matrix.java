import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        // Step 1: Add all 0s to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int[] dir : directions) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols 
                    && !visited[nr][nc]) {
                    
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return mat;
    }
}