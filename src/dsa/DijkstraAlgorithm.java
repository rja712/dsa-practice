package dsa;

import java.util.*;

public class DijkstraAlgorithm {

    Map<Integer, List<Edge>> adj = new HashMap<>();

    record Edge(int node, int weight) {
    }

    record NodeDistance(int node, int distance) {
    }

    void addEdge(int from, int to, int weight) {
        adj.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
    }

    Map<Integer, Integer> shortestPath(int source) {

        Map<Integer, Integer> distanceMap = new HashMap<>();
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(NodeDistance::distance));

        distanceMap.put(source, 0);
        pq.offer(new NodeDistance(source, 0));

        while (!pq.isEmpty()) {

            NodeDistance current = pq.poll();

            int newDistance = current.distance;
            int oldDistance = distanceMap.get(current.node);

            if (newDistance > oldDistance){
                continue;
            }

            List<Edge> neighbours = adj.getOrDefault(current.node, List.of());

            for (Edge neighbour: neighbours){
                int newDistanceOfNeighbour = newDistance + neighbour.weight ;
                int oldDistanceOfNeighbour =  distanceMap.getOrDefault(neighbour.node, Integer.MAX_VALUE);
                if (newDistanceOfNeighbour < oldDistanceOfNeighbour){
                    distanceMap.put(neighbour.node, newDistanceOfNeighbour);
                    pq.add(new NodeDistance(neighbour.node, newDistanceOfNeighbour));
                }
            }

        }
        return distanceMap;
    }
}