package graph;

import java.util.function.IntPredicate;

/**
 * union-find 算法
 * 
 * N个节点，统计它们是否连通，以及包含多少个分量
 * 互相连通的节点为一个分量。
 * @author Administrator
 *
 */
public class UF {
	
	private int[] id;	//分量id
	private int count;	//分量数量
	
	public UF(int N){
		count =N;
		id = new int[N];
		
		for(int i=0;i<N;i++){
			id[i] = i;
		}
	}
	
	public int count(){
		return count;
	}
	
	//判断两个节点是否联通
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	//查找节点p属于哪个分量
	public int find(int p){
		return id[p];
	}
	
	//设置节点p,q为连通的
	public void union(int p,int q){
		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID)return;
		
		for(int i=0;i<id.length;i++){
			if(id[i]==qID){
				id[i] = pID;
			}
		}
		count--;
	}

}
