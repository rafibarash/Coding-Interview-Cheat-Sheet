package Graph;

import java.util.*;

/**
 A class that implements the ADT undirected graph.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */
public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T>
{
    public UndirectedGraph()
    {
        super();
    }

    public boolean addEdge(T begin, T end, double edgeWeight) { return false; }

    public boolean addEdge(T begin, T end)
    {
        return false;
    }

    public int getNumberOfEdges() { return 0; }

    public Stack<T> getTopologicalOrder()
    {
        throw new UnsupportedOperationException("Topological sort illegal in an undirected graph.");
    }
}