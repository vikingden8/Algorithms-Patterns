package com.viking.algorithms.dfs.ex01;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/7/25
 */
public class Vertex {

    private String name ;

    private boolean isVisited ;

    private List<Vertex> neighbourList ;

    public Vertex(String name){
        this.name = name ;
        neighbourList = new ArrayList<>() ;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void addNeighbour(Vertex v){
        this.neighbourList.add(v) ;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
