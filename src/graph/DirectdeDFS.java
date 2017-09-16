package graph;

import java.util.Iterator;

/**
 * 判断有向图的可达性
 * 给定一个有向图和一个/一组顶点
 * 判断能到达哪些顶点（能到达的顶点在marked中为true）
 * @author Administrator
 *
 */
public class DirectdeDFS {

	private boolean[] marked;
	public DirectdeDFS(Digraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	public DirectdeDFS(Digraph G,Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s:sources){
			if(!marked[s]){
				dfs(G,s);
			}
		}
	}
	
	private void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	public boolean marked(int v){
		return marked[v]; 
	}
}
