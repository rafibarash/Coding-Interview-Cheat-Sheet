package DataStructures.Graph;

/**
 A class that implements the ADT directed graph.
 */

import java.util.*;

public class DirectedGraph<T> implements GraphInterface<T>, GraphSearchInterface<T>
{
    private HashMap<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public DirectedGraph() {
        vertices = new HashMap<>();
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return null == vertices.put(vertexLabel, new Vertex<>(vertexLabel));
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);

        if (result)
            edgeCount++;

        return result;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        boolean found = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            } // end while
        } // end if

        return found;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    @Override
    public VertexInterface<T> getVertex(T label) {
        return vertices.get(label);
    }

    private class VertexIterator implements Iterator<VertexInterface<T>> {
        private Iterator<Map.Entry<T, VertexInterface<T>>> verticeIterator;

        private VertexIterator() {
            verticeIterator = vertices.entrySet().iterator();
        } // end default constructor

        public boolean hasNext() {
            return verticeIterator.hasNext();
        } // end hasNext

        public VertexInterface<T> next() {
            return verticeIterator.hasNext() ? vertices.get(verticeIterator.next().getValue().getLabel()) : null;
        } // end next
    }

    public VertexIterator getVertexIterator() {
        return new VertexIterator();
    }

    @Override
    public Queue<T> getBreadthFirstTraversal(T origin) {
        Queue<T> traversalOrder = new LinkedList<>();
        Queue<VertexInterface<T>> vertexQueue = new LinkedList<>();

        VertexInterface<T> originVertex = getVertex(origin);
        if (isEmpty() || originVertex == null) {
            return traversalOrder;
        }

        originVertex.visit();
        vertexQueue.add(originVertex);
        traversalOrder.add(originVertex.getLabel());

        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> frontVertex = vertexQueue.poll();
            Iterator<VertexInterface<T>> frontVertexIterator = frontVertex.getNeighborIterator();
            while (frontVertexIterator.hasNext()) {
                VertexInterface<T> neighbor = frontVertexIterator.next();
                if (!neighbor.isVisited()) {
                    neighbor.visit();
                    vertexQueue.add(neighbor);
                    traversalOrder.add(neighbor.getLabel());
                }
            }
        }

        return traversalOrder;
    }

    @Override
    public Queue<T> getDepthFirstTraversal(T origin) {
        Queue<T> traversalOrder = new LinkedList<>();
        Stack<VertexInterface<T>> vertexStack = new Stack<>();

        VertexInterface<T> originVertex = getVertex(origin);
        if (isEmpty() || originVertex == null) {
            return traversalOrder;
        }

        originVertex.visit();
        vertexStack.push(originVertex);
        traversalOrder.add(originVertex.getLabel());

        while (!vertexStack.isEmpty()) {
            VertexInterface<T> frontVertex = vertexStack.pop();
            Iterator<VertexInterface<T>> frontVertexIterator = frontVertex.getNeighborIterator();
            while (frontVertexIterator.hasNext()) {
                VertexInterface<T> neighbor = frontVertexIterator.next();
                if (!neighbor.isVisited()) {
                    neighbor.visit();
                    vertexStack.push(neighbor);
                    traversalOrder.add(neighbor.getLabel());
                }
            }
        }

        return traversalOrder;
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
