package com.viking.algorithms.dfs.ex03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 7/26/17 10:08 AM
 */

class Neighbor{
    public int vertexNum ;

    public Neighbor next ;

    public Neighbor(int vNum, Neighbor nbr){
        this.vertexNum = vNum ;
        this.next = nbr ;
    }
}

class Vertex{
    public String name ;

    public Neighbor adjList ;

    Vertex(String name, Neighbor neighbors){
        this.name = name ;
        this.adjList = neighbors ;
    }
}

public class DFSGraph {

    Vertex[] adjLists ;

    public DFSGraph(String fileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName)) ;
        String graphType = sc.next() ;
        boolean undirected = true ;
        if (graphType.equals("directed")){
            undirected = false ;
        }
        adjLists = new Vertex[sc.nextInt()] ;

        //read vertices
        for (int v = 0; v < adjLists.length ; v++){
            adjLists[v] = new Vertex(sc.next(), null) ;
        }

        //read edges
        while(sc.hasNext()){
            // read vertex names and translate to vertex numbers
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());

            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
            if (undirected) {
                adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
            }
        }
    }

    private int indexForName(String name) {
        for (int v=0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    // recursive dfs
    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("visiting " + adjLists[v].name);
        for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
            if (!visited[nbr.vertexNum]) {
                System.out.println("\n" + adjLists[v].name + "--" + adjLists[nbr.vertexNum].name);
                dfs(nbr.vertexNum, visited);
            }
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[adjLists.length];
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v]) {
                System.out.println("\nSTARTING AT " + adjLists[v].name);
                dfs(v, visited);
            }
        }
    }


    public void print() {
        System.out.println();
        for (int v = 0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        DFSGraph graph = new DFSGraph(file);
        graph.print();
        graph.dfs();
    }

}
