import javax.swing.Box;

/**
 * This class arranges a line of IceCreamCones in the form of a Queue
 * 
 * @author Ioanna Deni
 * @version 11/12/2017
 *
 */
public class IceCreamLine extends Box { 
	
	//Here we create the new Queue<T> that hold elements of type IceCreamCone
	private QueueLL<IceCreamCone> list;

	/**
	 * The constructor does nothing
	 */
	public IceCreamLine(){
		
		super(1);
		
		//the queue of iceCreams is initiated
		list = new QueueLL<IceCreamCone>();
	}
	
	/**
	 * The add method adds the element of type IceCreamCone to the queue
	 * 
	 */
	public void addIceCream(){
		
		//The variable that has the stored list of scoops
		IceCreamCone cone = new IceCreamCone();
		
		//We add a random ice cream
		cone.addRandom();
		
		//First we add it to the panel
		this.add(cone);
		
		//Then we add it to the queue
		list.enqueue(cone);
		
		validate();
		repaint();
		
		}
	
	/**
	 * The delete method deletes the top (first) element type IceCreamCone from the queue 
	 */
	public IceCreamCone deleteIceCream(){
		
		IceCreamCone iceCreamElement = null;
		
		if (!list.isEmpty()){
			
			iceCreamElement = list.dequeue();
			
			//this removes it from the view
			this.remove(iceCreamElement);
	    	
	    	validate();	
			repaint();
		}
		
		return iceCreamElement;
	}
	
	/**
	 * This method returns the top ice cream from the queue   
	 * 
	 * @return
	 */
	public IceCreamCone getIceCream(){
		
		IceCreamCone iceCreamElement = null;
		
		//if the queue is not empty
		if (!list.isEmpty()){
			//here we just look at it and not deleting
			iceCreamElement = list.peek();
			}
		return iceCreamElement;
	}
}
