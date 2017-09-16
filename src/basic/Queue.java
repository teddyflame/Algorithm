package basic;

import java.util.Iterator;

import org.w3c.dom.Node;

public class Queue<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return N;
	}
	
	//向表尾添加元素
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(isEmpty()){
			first = last;
		}else{
			oldlast.next = last;
		}
		N++;	
	}
	
	//从表头删除元素
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		
		if(isEmpty()){
			last = null;
		}
		N--;
		return item;
	
	}

	public Iterator<Item> iterator() {
		return null;
	}

	
}
