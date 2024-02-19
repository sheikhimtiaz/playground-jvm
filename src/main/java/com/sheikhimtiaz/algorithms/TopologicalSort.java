package com.sheikhimtiaz.algorithms;

import java.util.*;

public class TopologicalSort {
    public static void run() {
//        int n = 4;
//        int[] taken = new int[n];
//        int[] list = new int[n];
//        int[] inDegree = new int[n];
//        int[][] take = new int[n][n];
//        topSortFahimBhai(n, taken, list, inDegree, take);


//        Graph graph = new Graph(3);
//        graph.addEdge(0, 1);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
//
//        List<Integer> result = TopologicalSortWithBfs.topologicalSort(graph);
//        System.out.println(result);

        int[][] prerequisites = {{0,1},{1,2}};
        System.out.println(canFinish(3, prerequisites));
        int[][] prerequisites2 = {{0,1},{1,2},{2,0}};
        System.out.println(canFinish(3, prerequisites2));


    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer> > graph
                = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Initialize the graph and in-degrees
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Push all the nodes with no dependencies
        // (in-degree = 0) into the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Reduce the in-degree of all neighbors by 1
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;

                // Push the neighboring node if we have
                // covered all its dependencies (in-degree =
                // 0)
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if there is a node whose in-degree is not
        // zero
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
    private static void topSortFahimBhai(int n, int[] taken, int[] list, int[] inDegree, int[][] take) {
        int i, j, k;
        // when take[a][b] = 1, that means a must come before b
        // indegree[i] = number of items that that must come before i
        // when taken[i] = 1, means we already have taken ith item
        int invalid = 0;
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                if( inDegree[j]!=0 && taken[j]!=0 ) {
                    taken[j] = 1;
                    list[i] = j;
                    // in this step we are taking item j
                    // we'd update the indegree[k] of items that depended on j
                    for(k=0; k<n; k++) {
                        if( taken[k]!=0 && take[j][k] > 0 ) --inDegree[k];
                    }
                    break;
                }
            }
            if( j == n ) {
                invalid = 1;
            }
        }
        if( invalid != 0 ) System.out.println("There is no solution");
        else
            for(i=0; i<n; i++)
                System.out.println(list[i]);
    }
}

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int n) {
        adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}

class TopologicalSortWithBfs {
    public static void dfs(Map<Integer, List<Integer>> graph, int vertex, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, stack, visited);
            }
        }
        stack.push(vertex);
    }

    public static List<Integer> topologicalSort(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (int vertex : graph.getAdjacencyList().keySet()) {
            if (!visited.contains(vertex)) {
                dfs(graph.getAdjacencyList(), vertex, stack, visited);
            }
        }
        List<Integer> ordering = new ArrayList<>();
        while (!stack.isEmpty()) {
            ordering.add(stack.pop());
        }
        return ordering;
    }

}
