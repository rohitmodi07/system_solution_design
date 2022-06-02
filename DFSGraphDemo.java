package conquerred.faang;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class DFSGraphDemo {
	
	private static class Node{
		int data;
		boolean visited;
		Set<Node> seenList;
		
		public Node(int data) {
			this.data = data;
			this.seenList = new HashSet<>();
		}
		
		public Set<Node> getSeenList(){
			return this.seenList;
		}
		
		public void addInList(Node node) {
			this.seenList.add(node);
		}
		
	}
	
	//following method is used for depth first search in graph
	
	public void depthFirstSearch(Node node) {
		Stack<Node> stk = new Stack<>();
		stk.push(node);
		
		while(!stk.isEmpty()) {
			Node nd = stk.pop();
			
			if(!nd.visited) {
				nd.visited = true;
				nd.getSeenList().add(nd);
				System.out.println("Not visited ::::: "+nd.data);
			}
			Set<Node> listnode = nd.getSeenList();
			//displayListNodeVal(listnode);
			for (Node n : listnode) {
				if(n!=null && !n.visited) {
					stk.push(n);
				}
			}
		}
	}
	
	public void displayListNodeVal(Set<Node> listnode) {
		System.out.println(" List contains :::::::: ");
		for(Node n : listnode) {
			System.out.println(n.data);
		}
	}

	public static void main(String[] args) {
		DFSGraphDemo dbdemo = new DFSGraphDemo();
		
		Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);
        Node node90 =new Node(90);
        
        node40.addInList(node10);
        node40.addInList(node20);
        
        node20.addInList(node30);
        node10.addInList(node60);
        
        node30.addInList(node50);
        node30.addInList(node70);
        node30.addInList(node90);
        node60.addInList(node50);
        node60.addInList(node70);
        
        
        node70.addInList(node50);
        node70.addInList(node60);
        node70.addInList(node30);
        node70.addInList(node90);
        
        node90.addInList(node70);
        node90.addInList(node40);
        node90.addInList(node30);
        
        
        dbdemo.depthFirstSearch(node70);

	}

}
