package dsa;

import java.util.*;

public class GraphPractice {

    Map<Integer, List<Integer>> adj;


    void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    void dfs(int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.println(node);

        List<Integer> neighbours = adj.getOrDefault(node, List.of());
        for (Integer neighbour : neighbours) {
            dfs(neighbour, visited);
        }
    }


    boolean hasPath(int source, int destination) {
        return hasPath(source, destination, new HashSet<Integer>());
    }

    boolean hasPath(Integer node, int target, Set<Integer> visited) {
        if (node == target) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        List<Integer> neighbours = adj.getOrDefault(node, List.of());
        for (Integer neighbour : neighbours) {
            if (hasPath(neighbour, target, visited)) {
                return true;
            }
        }

        return false;
    }

    void bfs(int source) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.println(current);

            List<Integer> neighbours = adj.getOrDefault(current, List.of());

            for (Integer neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    int connectedComponents() {

        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for (Integer node : adj.keySet()) {

            if (!visited.contains(node)) {
                count++;
                dfs(node, visited);
            }
        }
        return count;
    }


    boolean hasCycleUndirected() {

        Set<Integer> visited = new HashSet<>();

        for (Integer node : adj.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycleUndirected(node, null, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean hasCycleUndirected(Integer node, Integer parent, Set<Integer> visited) {

        visited.add(node);

        List<Integer> neighbours = adj.getOrDefault(node, List.of());
        for (Integer neighbour : neighbours) {

            if (Objects.equals(neighbour, parent)) {
                continue;
            }

            if (visited.contains(neighbour)) {
                return true;
            }

            if (hasCycleUndirected(neighbour, node, visited)) {
                return true;
            }
        }
        return false;
    }

    boolean hasCycleDirected() {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> activePath = new HashSet<>();

        for (Integer node : adj.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycleDirected(node, visited, activePath)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleDirected(Integer node, Set<Integer> visited, Set<Integer> activePath) {

        if (visited.contains(node)) {
            return activePath.contains(node);
        }

        visited.add(node);
        activePath.add(node);

        List<Integer> neighbours = adj.getOrDefault(node, List.of());
        for (Integer neighbour : neighbours) {
            if (hasCycleDirected(neighbour, visited, activePath)) {
                return true;
            }
        }

        activePath.remove(node);
        return false;
    }

    List<Integer> topologicalSort() {

        Set<Integer> visited = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (Integer node : adj.keySet()) {
            if (!visited.contains(node)) {
                topologicalSort(node, visited, answer);
            }
        }
        Collections.reverse(answer);
        return answer;

    }

    void topologicalSort(Integer node, Set<Integer> visited, List<Integer> answer) {

        if (visited.contains(node)){
            return;
        }

        List<Integer> neighbours = adj.getOrDefault(node, List.of());

        for (Integer neighbour : neighbours) {
            topologicalSort(neighbour, visited, answer);
        }

        answer.add(node);
    }

    List<Integer> topologicalSortWithCycleDetection() {

        Set<Integer> visited = new HashSet<>();
        Set<Integer> activePath = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (Integer node : adj.keySet()) {
            if (!visited.contains(node)) {
                if(topologicalSortWithCycleDetection(node, visited, activePath, answer)){
                    //cycle detected
                    return List.of();
                };
            }
        }
        Collections.reverse(answer);
        return answer;

    }

    boolean topologicalSortWithCycleDetection(Integer node, Set<Integer> visited, Set<Integer> activePath, List<Integer> answer) {

        if (visited.contains(node)) {
            return activePath.contains(node);
        }

        visited.add(node);
        activePath.add(node);

        List<Integer> neighbours = adj.getOrDefault(node, List.of());

        for (Integer neighbour : neighbours) {
            if (topologicalSortWithCycleDetection(neighbour, visited, activePath, answer)) {
                return true;
            }
        }

        activePath.remove(node);
        answer.add(node);

        return false;
    }


}


