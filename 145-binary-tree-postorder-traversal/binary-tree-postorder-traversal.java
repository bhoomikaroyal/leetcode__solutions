import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        postorder(root.left, list);   // Left
        postorder(root.right, list);  // Right
        list.add(root.val);           // Root
    }
}