package Graph;

import java.util.*;

/**
 A class that implements the ADT directed graph.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */
public class DirectedGraph<T> implements GraphInterface<T>, GraphSearchInterface<T> {

    private HashMap<T,  VertexInterface<T>> vertices;
    private int edgeCount;

    public DirectedGraph() {
        vertices = new HashMap<>();
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return false;
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    @Override
    public int getNumberOfEdges() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public VertexInterface<T> getVertex(T label) {
        return null;
    }

    @Override
    public Queue<T> getBreadthFirstTraversal(T origin) {
        return null;
    }

    @Override
    public Queue<T> getDepthFirstTraversal(T origin) {
        return null;
    }

    @Override
    public Stack<T> getTopologicalOrder() {
        return null;
    }

    @Override
    public int getShortestPath(T begin, T end, Stack<T> path) {
        return 0;
    }

    @Override
    public double getCheapestPath(T begin, T end, Stack<T> path) {
        return 0;
    }
}
