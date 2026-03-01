import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        Queue<Object[]> queue = new LinkedList<>();
        
        queue.offer(new Object[]{root, 0, 0}); // node, row, col
        
        while (!queue.isEmpty()) {
            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];
            
            if (node == null) continue;
            
            nodes.add(new int[]{col, row, node.val});
            
            queue.offer(new Object[]{node.left, row + 1, col - 1});
            queue.offer(new Object[]{node.right, row + 1, col + 1});
        }
        
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // sort by column
            if (a[1] != b[1]) return a[1] - b[1];   // sort by row
            return a[2] - b[2];                     // sort by value
        });
        
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        
        for (int[] node : nodes) {
            if (node[0] != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node[0];
            }
            result.get(result.size() - 1).add(node[2]);
        }
        
        return result;
    }
}