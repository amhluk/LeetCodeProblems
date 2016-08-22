// 133. Clone Graph
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /* DFS SOLUTION
    private UndirectedGraphNode dps(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            nodeCopy.neighbors.add(dps(neighbor, map));
        }
        return nodeCopy;
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dps(node, map);
    } */
    
    /* BFS SOLUTION */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(curNode).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.get(curNode).neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
            }
        }
        return nodeCopy;
    }
}