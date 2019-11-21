//package com.company;

public /*static*/ class Node {
    private Object obj;
    private Node next;

    Node (Object x){
        obj = x;
    }

    void setNext(Node x){
        next = x;
    }

    public Node getNext(){
        return this.next;
    }
    public Object getData(){
        return obj;
    }
}
