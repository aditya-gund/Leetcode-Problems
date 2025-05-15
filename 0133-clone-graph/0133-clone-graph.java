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
        return dfs(node, new HashMap<>());
    }
    // Implementation of the DFS Methos using HashMap
    private Node dfs(Node node, Map<Node,Node> visited){
        // Base condition
        if(node == null) return null;
        // Check if node is visited or not 
        if(visited.containsKey(node)) return visited.get(node);
        // Intialize the Clone Node object
        Node clone = new Node(node.val);
        // Insert the Original node and clone Node into the map
        visited.put(node,clone);
        for(Node neighbor: node.neighbors){
                clone.neighbors.add(dfs(neighbor,visited));
        }
        return clone;
    }
}