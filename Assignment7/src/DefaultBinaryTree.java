/**
 * This class contains the method definitions for a binary tree. 
 * A root statement that either leads to a left or a right statement and so on connected with the root but expanding.
 * 
 * @author Ioanna Deni
 * @version 11/24/2017
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>{
	
	//These are all the necessary instances to track the inorder post order and preorder traversals of a tree
	public BinaryTreeNode<T> currentRoot;
	
	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot(){
		if(currentRoot != null){
			return currentRoot;
		}
		return null;
	}

	/**
	 * Set the root node for this tree.
	 */
	public void setRoot(BinaryTreeNode<T> root){
		currentRoot= root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty(){
		if (currentRoot == null){
			return true;
		}
		return false;
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal(){
		
		LinkedList<T> inorderList= new LinkedList<T>();
		
		inorderTraversal(currentRoot, inorderList);
		
		return inorderList;
	}
	
	/**
	 * In this traversal the left sub tree is visited first and the leaf is printed 
	 * then the node connecting the leaf and the right sub tree leaf is printed 
	 * lastly the right sub tree leaf is printed and it goes on recursively for all nodes print first left then node then right 
	 * and a linkList is filled 
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		
		if (node!= null){
			
			inorderTraversal(node.getLeftChild(), traversal);
			
			traversal.add(traversal.size(), node.getData());
			
			inorderTraversal(node.getRightChild(), traversal);
			
		}
		
	}
	
	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal(){
		
		LinkedList<T> preorderList= new LinkedList<T>();
		
		preorderTraversal(currentRoot, preorderList);
		
		return preorderList;
	}
	
	/**
	 * In this traversal the value at the given node is printed first 
	 * then the left and then the right sub tree are visited.
	 * This is recursive for all nodes till the leaves and a linkList is filled 
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		
		if (node!=null){
			
			traversal.add(traversal.size(), node.getData());
			
			preorderTraversal(node.getLeftChild(), traversal);
			
			preorderTraversal(node.getRightChild(), traversal);
			
		}
		
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal(){
		
		LinkedList<T> postorderList= new LinkedList<T>();
		
		postorderTraversal(currentRoot, postorderList);
		
		return postorderList;
	}
	
	/**
	 * In this traversal the left and then the right sub tree are visited 
	 * and then the value at the given node is printed.
	 * This is recursive for all nodes till the leaves and a linkList is filled 
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		
		if (node!= null){
			
			postorderTraversal(node.getLeftChild(), traversal);
			
			postorderTraversal(node.getRightChild(), traversal);
			
			traversal.add(traversal.size(), node.getData());
			
		}
		
	}
	
	
	/**
	 * Creates a DefaultBinaryTree instance, and a tree corresponding to the Seven Dwarves example from lecture 
	 * It initiate the tree by make a binary tree data structure 
	 * by calling the setLeftChild and setRightChild methods on the DefaultBinaryTreeNode objects, 
	 * and setRoot on the the DefaultBinaryTree object.
	 * 
	 * @param args - here none
	 */
	public static void main(String args[])
	{
		
		DefaultBinaryTree<String> tree = new DefaultBinaryTree<String>();
		
		//first we create a DefaultBinaryTreeNode of type <String> for each Dwarf
		DefaultBinaryTreeNode<String> root = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> node1 = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> node2 = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> node3 = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> node4 = new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> node5 = new DefaultBinaryTreeNode<String>();
		
		//then we set the data of the nodes
		root.setData("Happy");
		node1.setData("Doc");
		node2.setData("Bashful");
		node3.setData("Grumpy");
		node4.setData("Sleepy");
		node5.setData("Sneezy");
		
		//then by calling the setLeftChild and setRightChild methods on the DefaultBinaryTreeNode objects,
		//and setRoot on the the DefaultBinaryTree object we set the relationships of the nodes
		tree.setRoot(root);
		root.setLeftChild(node1);
		root.setRightChild(node4);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node4.setRightChild(node5);
		
		
		//here we print all the traversals
		System.out.println("in order = " + tree.inorderTraversal());
		System.out.println("pre order = " + tree.preorderTraversal());
		System.out.println("post order = " + tree.postorderTraversal());
		
	}

}
