package com.ozka.main;

public class NodeT implements SGet {

    private Object obj;
    private Node next;

    T (Object x){
        obj = x;
    }

    void setNext(Node x){
        next = x;
    }

    public T getNext(){
        return next;
    }

    public Object getData(){
        return obj;
    }
}

