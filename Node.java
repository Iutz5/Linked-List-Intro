/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author avecaschilling
 */
public class Node {
    private int _data;
    private Node _next;
    
    public Node(int d, Node n){
        _data = d;
        _next = n;
    }
    
    public Node(int d){
        _data = d;
        _next = null;
    }
    
    public int data(){
        return _data;
    }
    
    public Node next(){
        return _next;
    }
    
    public void setNext(Node n){
        _next = n;
    }
    
    @Override
    public String toString(){
        return _data + " ";
    }
}
