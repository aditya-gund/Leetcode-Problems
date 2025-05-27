/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Call recursive method
        return dfs(node, new HashMap<>());
    }
    // Recursive Method DFS
    private Node dfs(Node node, Map<Node,Node> visited){
        // Base condition
        if(node== null) return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        // Intialize clone node
        Node clone = new Node(node.val);
        visited.put(node,clone);
        for(Node neighbor: node.neighbors){
                clone.neighbors.add(dfs(neighbor, visited));
        }
        return clone;
    }
}