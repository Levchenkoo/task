package com.company.util;

import com.company.model.Location;
import com.company.model.Route;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

public class PathInGraph {
    private final SimpleWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    private final List<Location> vertices;
    private final List<Route> routes;

    public PathInGraph(List<Location> vertices, List<Route> routes) {
        this.vertices = vertices;
        this.routes = routes;

        addVertices();
        addEdges();
    }

    private void addVertices() {
        for (Location vertex : vertices) {
            graph.addVertex(vertex.getId());
        }
    }

    private void addEdges() {
        for (Route route : routes) {
            DefaultWeightedEdge edge = graph.addEdge(route.getIdFrom(), route.getIdTo());
            if (edge != null) {
                graph.setEdgeWeight(edge, route.getCost());
            }
        }
    }

    public int determineShortestPath(int from, int to) {
        DijkstraShortestPath<Integer, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return (int) dijkstraShortestPath.getPath(from, to).getWeight();
    }
}
