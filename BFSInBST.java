package conquerred.datastructure;

public class BFSInBST {
	
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
	
	
	//print nodes level wise , it is also called BFS in tree
	
	public int heightoftree(Node root) {
		if(root == null)
			return 0;
		return 1+Math.max(heightoftree(root.left), heightoftree(root.right));
	}
	
	public void findLevelNodes(Node root) {
		int h = heightoftree(root);
		for (int i = 1; i <= h; i++) {
			printlevel(root, i);
		}
	}
	
	public void printlevel(Node root, int h) {
		
		if (root == null)
            return;
   
		if(h == 1) {
			System.out.println(" the value at each level is : "+root.value);
		}else {
			printlevel(root.left, h-1);
			printlevel(root.right, h-1);
		}
	}
	

	public static void main(String[] args) {
		BFSInBST bst = new BFSInBST();
		Node root = new Node(10);
		bst.insertInTree(root, 9);
		bst.insertInTree(root, 15);
		bst.insertInTree(root, 6);
		bst.insertInTree(root, 12);
		bst.insertInTree(root, 13);
		bst.insertInTree(root, 20);
		
		bst.findLevelNodes(root);

	}

}
