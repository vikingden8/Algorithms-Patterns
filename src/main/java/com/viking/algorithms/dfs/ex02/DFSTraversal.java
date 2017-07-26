package com.viking.algorithms.dfs.ex02;

import java.util.LinkedList;
import java.util.List;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 7/25/17 4:37 PM
 *
 * Java program to print DFS traversal from a given given graph
 */
public class DFSTraversal {

    static class Graph{
        private int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        private List<List<Integer>> adj;

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList<List<Integer>>();
            for (int i=0; i<v; ++i)
                adj.add(new LinkedList<Integer>()) ;
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj.get(v).add(w) ;// Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[])
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            for (Integer n : adj.get(v)) {
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }
        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS(int v)
        {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
