package graph;

import java.util.Stack;

import basic.Queue;

public class DepthFirstOrder {

	private boolean[] marked;
	//所有顶点的前序排列
	private Queue<Integer> pre;
	//所有顶点的后序排列
	private Queue<Integer> post;
	//所有顶点的逆后序排列
	private Stack<Integer> reversePost;
	
	
	public DepthFirstOrder(Digraph G){
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		
		marked = new boolean[G.V()];
		
		for(int v=0;v<G.V();v++){
			if(!marked[v]){
				dfs(G,v);
			}
		}
	}
	
	private void dfs(Digraph G,int v){
		//前序排列：遍历前将该顶点加入队列
		//即DFS走过的顺序
		pre.enqueue(v);
		
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
		//后序排列：递归调用之后将该顶点加入队列
		//即顶点遍历完成的顺序
		post.enqueue(v);
		//逆后序排列：递归调用完成之后，将该顶点压栈
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	
	public Iterable<Integer> post(){
		return post;
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
	
	
	
	
}
