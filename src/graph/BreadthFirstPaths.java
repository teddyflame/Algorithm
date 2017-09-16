package graph;

import java.util.LinkedList;
import java.util.Stack;

import basic.Queue;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G,int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G,int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;	//标记起点
		System.out.println(s);
		queue.enqueue(s);	//将它加入队列
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w:G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					System.out.println(w);
					queue.enqueue(w);
				}
			} 
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
