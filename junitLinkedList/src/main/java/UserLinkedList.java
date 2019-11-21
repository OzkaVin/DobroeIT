//package com.company;

public class UserLinkedList {
    public Node first;
    public Node last;

    private static int size;

    public UserLinkedList(){
        size = 0;
    }

    public boolean add(Object element){

        // first element adding
        if(first == null){
            first = new Node(element);
            last = first;
        }
        else {
            Node newNode = new Node (element);
            last.setNext(newNode);
            last = last.getNext();
        }
        size++;
        return true;
    }

    int size(){
        return size;}

    boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    boolean remove(Object element) {
        if (size > 0) {
            Node curr = first;

            //the one we looked for is the first element
            if (curr.getData() == element){
                first = curr.getNext();
                return true;
            }

            do {
                if ((curr.getNext()).getData() == element){

                    curr.setNext((curr.getNext()).getNext());
                    return true;
                }
                curr = curr.getNext();
            } while (curr != null);
        }
        return false;
    }

    boolean contains(Object element) {
        if (size > 0) {
            Node curr = first;
            do{
                if (curr.getData() == element)
                    return true;
                curr = curr.getNext();
            }while (curr != null);
        }
        return  false;
    }

    void print(){
        if(size > 0){
            Node curr = first;
            do {
                System.out.println(curr.getData());
                curr = curr.getNext();
            } while (curr != null);
        }
    }
}
