package com.ozka.main;

public class NodeT <T> /*implements SGet*/ {

    private T item;
    private NodeT next;

    NodeT (T x){
        item = x;
    }

    void setNext(NodeT x){
        next = x;
    }

    public NodeT getNext(){
        return next;
    }

    public T getData(){
        return item;
    }
}

