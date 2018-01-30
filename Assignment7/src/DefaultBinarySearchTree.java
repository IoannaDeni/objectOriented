
public class DefaultBinarySearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinarySearchTree<T>{
	
	/**
	 * The constructor makes sure that the variables used in the class the DefaultBinarySearchTree extends are transferred here 
	 */
	public DefaultBinarySearchTree(){
		super();
	}
	
	  /**
	   * Insert the data into the tree, maintaining the
	   * search tree invariant.
	   */  
	  public void insert( T data ){
		  
		//If the tree hasn't been initiated before we create the root and set the data to this root.
		if (currentRoot == null){
			currentRoot = new DefaultBinaryTreeNode<T>();
			currentRoot.setData(data);
		}
		else{
		
			//if the tree has been initiated the root is the first
			BinaryTreeNode<T> current = currentRoot;
			insert (data, current);
		}
	  }
	  
	  /**
	   * This is the same method as the above public method but like this we are allowed to do it recursively
	   * by giving it a different node instead of the root
	   * 
	   * @param data
	   * @param node
	   */
	  private void insert (T data, BinaryTreeNode<T> node){
		  //iterate through the nodes and find the place the data belong (assuming they are ordered numbers )
			
		  if (data.compareTo(node.getData()) < 0 && node.getLeftChild() != null){
			  //if the input is smaller than the node we are currently and the node has a left child
			  insert(data, node.getLeftChild());
			  //we visit the left sub tree and continue comparing
		  }
		  
		  else if (data.compareTo(node.getData()) < 0 && node.getLeftChild() == null){
			//if the input is smaller than the node we are currently and the node doesn't has a left child
			  BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
			  //we set the data to the new node
			  newNode.setData(data);
			  //and create a pointer
			  node.setLeftChild(newNode);  
		  }
		  //if the input is bigger than the node we are currently 
		  else if (data.compareTo(node.getData()) > 0  && node.getRightChild() != null ){
			  insert(data, node.getRightChild());
			//we visit the right sub tree and continue comparing
		  }  
		  
		  else if (data.compareTo(node.getData()) > 0  && node.getRightChild() == null ){
			//if the input is bigger than the node we are currently and the node doesn't has a right child
			  BinaryTreeNode<T> newNode = new DefaultBinaryTreeNode<T>();
			  //we set the data to the new node
			  newNode.setData(data);
			  //and create a pointer
			  node.setRightChild(newNode);  
		  }
	  }

	  /**
	   * Search for data in the tree, calling the private method.
	   * @return the node containing data or null if none exists.
	   */
	  public BinaryTreeNode<T> search(T data){
		  if (currentRoot != null){
			  return search(currentRoot, data);
		  }
		  
		  return null;
	  }
	  
	  /**
	   * Search for data in the tree, finding the node
	   * containing it, or null if the data is not present
	   * in the tree.
	   * 
	   * @param node
	   * @param data
	   * @return the node containing data or null if none exists.
	   */
	  private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T data){
		  
		  //first we compare the current node and if it contains the data then we return that node
		  if(data.compareTo(node.getData()) == 0){
			  //base case
					return node;
				}
		  //if the data are not on that node then we look at the left sub tree only if that sub tree exist 
		  else if (data.compareTo(node.getData()) < 0){
			  
			  if (node.getLeftChild() != null){
					return search(node.getLeftChild(), data);
					}
				//if the data are not on that node then we look at the left sub tree and  the left sub tree doesn't exist
				  return null;
		  }
		  //if the data are not on that node and are not smaller than the node then we look at the right sub tree only if that sub tree exist
		  else if (data.compareTo(node.getData()) > 0){
			  
			  if (node.getRightChild() != null){
					return search(node.getRightChild(), data);
			  }
				//if the data are not on that node then we look at the right sub tree and  the right sub tree doesn't exist
				  return null;
		  	}
		  //if the conditions are not met then it is not part of the tree and null is returned
		  return null;
		  }	

	  
	  /**
	   * Find the minimum element in the tree.
	   */
	  public T minElement(){
		  
		  T value = null;
		  
		  if (currentRoot == null){
			  return value;
		  }
		  
		//if the tree has been initiated the root is the first
		BinaryTreeNode<T> current = currentRoot;
		
		//as long as the tree has a left sub tree a smaller value will exist
		while (current.getLeftChild() != null){
			value = current.getLeftChild().getData();
			current = current.getLeftChild();
		}
		
		  
		return value;  
		  
	  }

	  /**
	   * Find the maximum element in the tree.
	   */
	  public T maxElement(){
		  
		  T value = null;
		  
		  if (currentRoot == null){
			  return value;
		  }
		  
		//if the tree has been initiated the root is the first
		BinaryTreeNode<T> current = currentRoot;
		
		//as long as the tree has a left sub tree a smaller value will exist
		while (current.getRightChild() != null){
			value = current.getRightChild().getData();
			current = current.getRightChild();
		}
		  
		return value;  
		  
	  }

}
