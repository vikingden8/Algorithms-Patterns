package com.viking.algorithms.dfs.ex01;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/7/25
 */
public class Main {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1") ;
        Vertex v2 = new Vertex("2") ;
        Vertex v3 = new Vertex("3") ;
        Vertex v4 = new Vertex("4") ;
        Vertex v5 = new Vertex("5") ;
        Vertex v6 = new Vertex("6") ;

        v1.addNeighbour(v2) ;
        v1.addNeighbour(v3) ;
        v2.addNeighbour(v3) ;

        v4.addNeighbour(v6);
        v4.addNeighbour(v5);

        List<Vertex> vertexList = new ArrayList<>() ;
        vertexList.add(v1) ;
        vertexList.add(v2) ;
        vertexList.add(v3) ;
        vertexList.add(v4) ;
        vertexList.add(v5) ;
        vertexList.add(v6) ;

        DFS dfs = new DFS() ;
        dfs.dfs(vertexList);
    }


}
