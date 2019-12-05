package com.ozka.main;

public class UserLinkedListT <T> /*<T extends SGet>*/ {
    private Node first;
    private Node last;

    private static int size;

    public UserLinkedListT(){
        size = 0;
    }

    public boolean add(T item){

        // first element adding
        if(first == null){
            first = new Node(item);
            last = first;
        }
        else {
            Node newNode = new Node (item);
            last.setNext(newNode);
            last = last.getNext();
        }
        size++;
        return true;
    }

    public int size(){
        return size;}

    boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    public boolean remove(T item) {
        if (size > 0) {
            Node curr = first;

            //if the one we looked for is the first element
            if (curr.getData() == item){
                first = curr.getNext();
                size--;
                return true;
            }

            do {
                if ((curr.getNext()).getData() == item){

                    curr.setNext((curr.getNext()).getNext());
                    size--;
                    return true;
                }
                curr = curr.getNext();
            } while (curr != null);
        }
        return false;
    }

    public boolean contains(T item) {
        if (size > 0) {
            Node curr = first;
            do{
                if (curr.getData() == item)
                    return true;
                curr = curr.getNext();
            }while (curr != null);
        }
        return  false;
    }
}

