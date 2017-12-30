package Graph;

import java.util.*;

class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private List<Edge> edgeList; // Edges to neighbors
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedList<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    }

    @Override
    public T getLabel() {
        return null;
    }

    @Override
    public void visit() {

    }

    @Override
    public void unVisit() {

    }

    @Override
    public boolean isVisited() {
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return false;
    }

    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return null;
    }

    @Override
    public Iterator<Double> getWeightIterator() {
        return null;
    }

    @Override
    public boolean hasNeighbor() {
        return false;
    }

    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        return null;
    }

    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {

    }

    @Override
    public VertexInterface<T> getPredecessor() {
        return null;
    }

    @Override
    public boolean hasPredecessor() {
        return false;
    }

    @Override
    public void setCost(double newCost) {

    }

    @Override
    public double getCost() {
        return 0;
    }

    public void display() // For testing
    {
        System.out.print(label + " " );
        Iterator<VertexInterface<T>> i = getNeighborIterator();
        Iterator<Double> w = getWeightIterator();

        while (i.hasNext())
        {
            Vertex<T> v = (Vertex<T>)i.next();
            System.out.print(v + " " + w.next() + " ");

        }
        System.out.println();
    }

    protected class Edge {
        private VertexInterface<T> vertex; // Vertex at end of edge
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight;
        } // end getWeight
    }

}
