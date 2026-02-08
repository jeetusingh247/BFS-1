// Time : O(n) , since we are traversing each element in the tree
// Space: O(n/2) --> O(n), since we are counting child nodes 
// on popping each parent node going down level by level
// Approach To Solve: solved it using breadth-first-search or bfs or level
// order traversal using FIFO(first in first out) using queue, we can
// also solve using DFS as well.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            result.add(temp);
        }
        return result;
    }
}