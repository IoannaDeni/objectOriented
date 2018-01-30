package datastructures;
/**
 * This class contains the method definitions for a binary tree. 
 * A root statement that either leads to a left or a right statement and so on connected with the root but expanding.
 * 
 * @author Ioanna Deni
 * @version 11/24/2017
 * @updated 12/7/2017
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
	 * This method calls the recursive private method that takes an empty array list and 
	 * fills it with all the leafs of the tree and returns it as a string 
	 * 
	 * @param root node
	 * @return an array of answers 
	 */
	public String leafsList(BinaryTreeNode<T> root){
		
		//creating the list - we only need one that we will keep expanding
		LinkedList<T> list = new LinkedList<T>();
		
		//calling the private method that fills the list
		leafsList(root, list);
		
		//return the string
		return list.toString();
	}
	
	/**
	 * This method accepts a root and recursively visits all the leafs and adds then to the 
	 * list that it also accepts as a parameter 
	 * 
	 * @param root the node 
	 * @param list the list that it will add
	 */
	private void leafsList(BinaryTreeNode<T> root, LinkedList<T> list){ 
		
		//if the root is empty do nothing
		if (root == null){
		}
		
		//if the root is a leaf add it to the list at the end of the list
		else if (root.isLeaf()){
			list.add(list.size(), root.getData());
		}
		
		// if the node is not a leaf and it has children we visit the children before adding anything to the list 
		else if (!root.isLeaf()){
			
			//first the left child
			leafsList(root.getLeftChild(), list);
			
			//then the right child recursively
			leafsList(root.getRightChild(), list);
		}
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

}
