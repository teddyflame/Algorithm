package graph;

import java.util.Iterator;
import java.util.Stack;

import basic.Queue;

public class TestGraph {

	public static void main(String[] args) {
		
		
//		DepthFirstPaths dfp = new DepthFirstPaths(graph, 0);
//		
//		BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
//		bfp.pathTo(1);
		
		
		//-------有向图中的有向环-------
//		Digraph graph = createDigraph();
//		
//		DirectdeDFS reach = new DirectdeDFS(graph, 7);
//
//		for(int i=0;i<graph.V();i++){
//			if(reach.marked(i)){
//				System.out.print(i+" ");
//			}
//		}
//		
//		System.out.println("");
		
		// -------有向无环图中的顶点排序 --------
		Digraph graph = createDigraphNoCycle();
		DepthFirstOrder order = new DepthFirstOrder(graph);
		
		//输出前序排列
		Queue<Integer> pre = (Queue<Integer>) order.pre();
		while(!pre.isEmpty()){
			System.out.print(pre.dequeue() +" ");
		}
		
		System.out.println("");
		
		//输出后序排列
		Queue<Integer> post = (Queue<Integer>) order.post();
		while(!post.isEmpty()){
			System.out.print(post.dequeue() +" ");
		}
		
		System.out.println("");
		
		//输出逆后序排列
		Stack<Integer> reversePost = 
				(Stack<Integer>) order.reversePost();
		while(!reversePost.isEmpty()){
			System.out.print(reversePost.pop() +" ");
		}
				
		System.out.println("");
	}
	
	private static Graph createGraph(){
		Graph graph = new Graph(6);
		
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,5);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(3,4);
		graph.addEdge(3,5);
		return graph;
	}
	
	//创建一个有向无环图
	private static Digraph createDigraphNoCycle(){
		Digraph graph = new Digraph(13);
		
		graph.addEdge(0,1);
		graph.addEdge(0,5);
		graph.addEdge(0,6);
		graph.addEdge(2,0);
		graph.addEdge(2,3);
		graph.addEdge(3,5);
		graph.addEdge(5,4);
		graph.addEdge(6,4);
		graph.addEdge(6,9);
		graph.addEdge(7,6);
		graph.addEdge(8,7);
		graph.addEdge(9,10);
		graph.addEdge(9,11);
		graph.addEdge(9,12);
		graph.addEdge(11,12);
		return graph;
	}
	
	
	//创建一个有向有环图
	private static Digraph createDigraph(){
		Digraph graph = new Digraph(13);
		
		graph.addEdge(4,2);
		graph.addEdge(2,3);
		graph.addEdge(3,2);
		graph.addEdge(6,0);
		graph.addEdge(0,1);
		graph.addEdge(2,0);
		graph.addEdge(11,12);
		graph.addEdge(12,9);
		graph.addEdge(9,10);
		graph.addEdge(9,11);
		graph.addEdge(8,9);
		graph.addEdge(10,12);
		graph.addEdge(11,4);
		graph.addEdge(4,3);
		graph.addEdge(3,5);
		graph.addEdge(7,8);
		graph.addEdge(8,7);
		graph.addEdge(5,4);
		graph.addEdge(0,5);
		graph.addEdge(6,4);
		graph.addEdge(6,9);
		graph.addEdge(7,6);
		
		return graph;
	}

}
