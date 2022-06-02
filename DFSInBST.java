package conquerred.datastructure;

import java.text.MessageFormat;

public class DFSInBST {
	
	private static class Node {
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	//insert in the tree
	
	public void insertInTree(Node root, int value) {
		if(root.value>value) {
			if(root.left!=null) {
				insertInTree(root.left, value);
			}else {
				root.left = new Node(value);
			}
		}else if(root.value<value) {
			if(root.right!=null) {
				insertInTree(root.right, value);
			}else {
				root.right = new Node(value);
			}
		}
	}
	
	//traversal , preorder, inorder, postorder, also called DFS in tree
	
	public void preorder(Node root) {            // root element will be the first element
		if(root!=null) {
			System.out.println(String.format("preorder traversal %s", root.value));
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(Node root) {    //integer will be in sorted format
		if(root!=null) {
			inorder(root.left);
			System.out.println(String.format("preorder traversal %s", root.value));
			//System.out.println(MessageFormat.format("inorder traversal %s", root.value));
			inorder(root.right);
		}
	}
	
	public void postorder(Node root) {    //root element will be at mid
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(MessageFormat.format("postorder traversal %s", root.value));
		}
	}
	
	

	public static void main(String[] args) {
		DFSInBST bst = new DFSInBST();
		Node root = new Node(10);
		bst.insertInTree(root, 9);
		bst.insertInTree(root, 15);
		bst.insertInTree(root, 6);
		bst.insertInTree(root, 12);
		bst.insertInTree(root, 13);
		bst.insertInTree(root, 20);
		
		bst.inorder(root);
		
		bst.preorder(root);

	}

}
