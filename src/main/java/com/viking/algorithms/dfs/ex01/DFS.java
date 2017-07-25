package com.viking.algorithms.dfs.ex01;

import java.util.List;
import java.util.Stack;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/7/25
 */
public class DFS {

    private Stack<Vertex> stack ;

    public DFS(){
        stack = new Stack<>() ;
    }

    public void dfs(List<Vertex> vertexs){
        for (Vertex vertex : vertexs){
            if (!vertex.isVisited()){
                vertex.setVisited(true);
                dfsWithStack(vertex) ;
            }
        }
    }

    private void dfsWithStack(Vertex vertex) {
        stack.push(vertex) ;
        while(!stack.isEmpty()){
            Vertex actualVertex = stack.pop() ;
            System.out.println(actualVertex.toString());
            for (Vertex v : actualVertex.getNeighbourList()){
                if (!v.isVisited()){
                    v.setVisited(true);
                    stack.push(v) ;
                }
            }
        }
    }
}
