import java.util.*;

public class Solution {
    
    public static boolean hasCycle(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        
        // Check for cycle in all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclic(i, -1, visited, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper method to check cycle using DFS
    private static boolean isCyclic(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        
        for (Integer neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, node, visited, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If an adjacent node is visited and it's not the parent, cycle detected
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1
        int V = 5;
        int E = 5;
        int[][] edges = { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0} };
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Create the adjacency list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean result = hasCycle(V, adjList);
        System.out.println("Cycle detected: " + result);  // Output: true
    }
}
