import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);        // Root
        preorder(root.left, list); // Left
        preorder(root.right, list);// Right
    }
}