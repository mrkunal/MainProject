package com.ttn.collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;

public class BFSExample {

    static class Graph {

        int vertices;
        LinkedList<Integer> adj[];

        public Graph(int vertices) {
            this.vertices = vertices;
            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }


        void addEdge(int i, int j) {
            adj[i].add(j);
        }

        void bfs(int node) {

            boolean visited[] = new boolean[vertices];

            LinkedList<Integer> queue = new LinkedList();
            queue.add(node);

            while (!queue.isEmpty()) {
                Integer queueNode = queue.poll();

                if(!visited[queueNode]){
                    System.out.println("Visit "+queueNode);
                    visited[queueNode]=true;
                    queue.addAll(adj[queueNode]);
                }

            }
        }

        void dfs(int node){

            boolean visited[]=new boolean[vertices];
            Stack<Integer> stck=new Stack<>();

            stck.push(node);
            while (!stck.isEmpty()){




            }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);

    }
}
