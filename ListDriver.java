/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
import List.*;

/**
 *
 * @author avecaschilling
 */
public class ListDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        
        //1.  Insert 6 nodes into the list at any position
        //    (must call insert.  may not use the crazy syntax I have
        //     in the commented portion of the LinkedList constructor)
        System.out.println("Inserting 6 nodes:");
        list.insert(3, 0);
        list.insert(4, 1);
        list.insert(5, 2);
        list.insert(1, 2);
        list.insert(7, 4);
        list.insert(10, 5);
        
        //    Print out the list 
        System.out.println("List: \n"+list);
        
        //2.  Remove element at position 3 (indices start at 0)
        System.out.println("Removing node at position 3:");
        list.remove(3);
        
        //    Print out the list
        System.out.println("List: \n"+list);
        
        //3.  Insert element w/ value 88 at position 0
        System.out.println("Inserting 88 at position 0");
        list.insert(88, 0);
        //    Print out the list
        System.out.println("List: \n"+list);      
        
        //4.  Insert element w/ value 42 at end of list
        list.insert(42,list.count());

        //    Print out the list 
        System.out.println("List: \n"+list);   
        
        //5.  Remove element at position 0
        System.out.println("Removing 88 at position 0");
        list.remove(0);
        //6.  Attempt to insert a value at position 98
        //    Print the return value with label "Insert at 98 Result:  "
        list.insert(5, 98);
        System.out.println("Insert at 98 Result: Nothing because boolean is false");
        //7.  Attempt to delete a value at position -98
        //    Print the return value with the label "Delete at -98 Result:"
        list.remove(-98);
        System.out.println("Delete at -98 Result: Nothing because boolean is false");
        //    Print out the list 
        System.out.println("List: \n"+list);      


        System.out.println("Summary: ");
        System.out.println("Count: " + list.count());
        System.out.println("List: \n"+list);
        System.out.println("isEmpty: "+ list.isEmpty());
        
        
        
        
    }
    
}
