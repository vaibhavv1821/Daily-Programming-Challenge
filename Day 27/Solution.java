import java.util.*;

public class Solution {

    public static int shortestPath(int V, List<int[]> edges, int start, int end) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

     
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); 
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1); 
        

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        
        while (!queue.isEmpty()) {
            int node = queue.poll();

           
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                   
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }

       
        return -1;
    }

    public static void main(String[] args) {
        
        int V1 = 5;
        List<int[]> edges1 = Arrays.asList(new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}});
        int start1 = 0, end1 = 4;
        System.out.println("Shortest Path Length: " + shortestPath(V1, edges1, start1, end1)); // Output: 3

        
        int V2 = 3;
        List<int[]> edges2 = Arrays.asList(new int[][]{{0, 1}, {1, 2}});
        int start2 = 0, end2 = 2;
        System.out.println("Shortest Path Length: " + shortestPath(V2, edges2, start2, end2)); // Output: 2

       
        int V3 = 4;
        List<int[]> edges3 = Arrays.asList(new int[][]{{0, 1}, {1, 2}});
        int start3 = 2, end3 = 3;
        System.out.println("Shortest Path Length: " + shortestPath(V3, edges3, start3, end3)); // Output: -1
    }
}
