package CodeSnippets;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer>[] adjList;
    private boolean[] visited;
    private int numVertices;

    Graph(int numVertices) {
        this.adjList = new LinkedList[numVertices];
        for(int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
        this.visited = new boolean[numVertices];
        Arrays.fill(visited, false);
        this.numVertices = numVertices;
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void DFSRecurrsive(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for(int i = 0; i < this.numVertices; i++) {
            Iterator<Integer> itr = this.adjList[i].iterator();
            while(itr.hasNext()) {
                Integer dest = itr.next();
                if(!visited[dest]) {
                    DFSRecurrsive(dest);
                }
            }
        }
    }

    public void DFS(int vertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        Arrays.fill(visited, false);
        
        while(!stack.isEmpty()) {
            Integer top = stack.pop();
            visited[top] = true;
            System.out.print(top + " ");
            Iterator<Integer> itr = this.adjList[top].iterator();

            while(itr.hasNext()) {
                Integer next = itr.next();
                if(!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

    public void BFS(int vertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        Arrays.fill(visited, false);

        while(!queue.isEmpty()) {
            Integer last = queue.poll();
            visited[last] = true;
            System.out.print(last + " ");

            Iterator<Integer> itr = adjList[last].iterator();
            while(itr.hasNext()) {
                Integer next = itr.next();
                if(!visited[next]) {
                    visited[next] = true;           /// NOTE: This is an important step. This will result in not having duplicate verices in our queue.
                    queue.add(next);
                }
            }
        }
    }
}