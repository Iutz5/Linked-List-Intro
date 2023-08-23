/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 * This class implements a singly linked, non-circular list
 * CS174 Lab
 * 3/2/2014
 * 
 * @author avecaschilling
 */
public class LinkedList {
    private static final int INSERT = 0;
    private static final int REMOVE = 1;
    private static final int LIST_INDEX = 2;
    private Node _head;
    
    /**
     * Constructor
     */
    public LinkedList(){
        _head = null;
        
        //**** dummy for testing purpose
        //_head = new Node(4,new Node(3, new Node(2,new Node (1, new Node (0)))));
    }
    
    /**
     * Inserts the data "d" into the list at position "p"
     * @param d - data to insert
     * @param p - new position of data after insert
     * @return true if insert occurred, false otherwise
     */
    public boolean insert(int d, int p){
        
        // validate the position p.  if it's not a valid position, do nothing.
        //boolean toReturn = true;
        boolean toReturn = validPosition(p,0);
        System.out.println(toReturn);
        if(toReturn == true){
            Node toInsert = new Node(d);

            //simple case: no elements

            if (_head==null){
                _head = toInsert;
            }else if (p==0){   
                //insert at head (positition 0)

                //point the inserted node to first node node in
                //list
                toInsert.setNext(_head);

                //point the head of the list to the inserted
                //node
                _head = toInsert;
            }else if (p==count()){

                //insert at end (position at length)
                // find last element
                toInsert = find(p-1);
                // set last element's next to toInsert
                toInsert.setNext(new Node(d));
            }else{

                //insert in middle (position at p)
                //pp= element right before position of insertion (ie find(p-1) )
                Node pp = find(p-1);
                //c = element at position of insertion (ie find(p))
                Node c = find(p);
                //
                //set toInsert's "next" to the element at p
                toInsert.setNext(c);
                //set pp's next to toInsert
                pp.setNext(toInsert);
            }
        }
        
        return toReturn;  //COMPILE DUMMY.  BE SURE TO CHANGE TO WORK CORRECTLY
    }
    
    /**
     * Removes the node at position "p" in the list and
     * returns the data in that node.
     * @param p
     * @return true if element was deleted, false otherwise
     */
    public boolean remove(int p){
        
        //boolean toReturn=true;//COMPILE DUMMY.  BE SURE TO SET THIS
        //validate the position using the validPosition method
        boolean toReturn = validPosition(p,1);
        if(toReturn == true){
            //pp=node previous to node we are deleting
            Node pp = find(p-1);
            //pn= node after node we are deleting
            Node pn = find(p+1);
            //set pp's next to pn
            if(p==0){
                pp = find(p);
                _head = pn;
            }
            pp.setNext(pn);
        }  
        return toReturn;
    }
    
    /**
     * 
     * @return returns the number of nodes in the list
     */
    public int count(){
        int toReturn=0;
        Node current = _head;
        
        while (current != null){
            toReturn++;
            current  = current.next();
        }
        return toReturn;
    }
    /**
     * Returns pointer to node at position p
     * @param p
     * @return 
     */
    private Node find(int p){
        Node current = _head;
        
        
        if (!validPosition(p,LIST_INDEX)){
            current = null;
        }else {
            int posCount = 0;
            while ( posCount<p){
                current = current.next();
                posCount++;
            }
        }       
          
        return current;
    }
    
    /**
     * 
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty(){
        return (_head == null);
    }
    
    /**
     * Checks if  position is appropriate for operation
     * @param p
     * @return true if operation is INSERT and index is between 0 and count
     *         true if operation is REMOVE, list is not empty, and index is 
     *                  between 0 and count-1
     *         true if operation is LIST_INDEX and index is between 0 and count-1
     */
    private boolean validPosition(int p, int function){
        boolean toReturn;
        if (function == INSERT){
            // If there's no elements in the list, you can insert at 0
            // and you can insert at one element past the last index
            toReturn = ( (p >= 0)  &&  (p <= count()));
        } else if (function == REMOVE){
            if (_head == null){     // can't remove from an empty list
                toReturn = false;
            } else if ( (p>=0)&& (p <= (count()-1))){
                toReturn = true;
            } else{
                toReturn = false;
            }
                
         } else if (function == LIST_INDEX) {
             toReturn = (p >= 0)  &&  (p <= (count()-1));
         } else
             toReturn = false;
            
        
        return toReturn;
       
    }
    
    @Override
    public String toString(){
        String toReturn = "";
        Node current = _head;
        
        while (current != null){
            toReturn = toReturn + current.data() + " ";
            current = current.next();
        }
        
        return toReturn;
    }
    
}
