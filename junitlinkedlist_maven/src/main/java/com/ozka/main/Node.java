package com.ozka.main;

public class Node {

    private Object obj;
    private Node next;

    Node (Object x){
        obj = x;
    }

    void setNext(Node x){
        next = x;
    }

    public Node getNext(){
        return next;
    }
    public Object getData(){
        return obj;
    }
}
