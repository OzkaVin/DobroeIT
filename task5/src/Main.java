//import java.util.LinkedList;
//import UserTreeSet.java;


public class Main {

    public static int binarySearch(int [] data, int element){

        int max = data.length;

        if(max > 1){
            //search
            int min = 0;
            int curr = (max+min)/2;

            for(; max!=min ; curr = (max+min)/2){

                if(data[curr] == element)
                    return curr;
                else if(data[curr] < element && curr!=min){
                    min=curr++;
                }
                else
                    max=curr--;
            }
        }
        else if (max == 1 && data[0]==element)
            return 0;

        return -1;
    }


    // Task 2
    public static class Node {
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

    public static class UserLinkedList{

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



    public static void main(String[] args) {

        // Task 2
        /*UserLinkedList olhaList = new UserLinkedList();
        olhaList.add(5);
        olhaList.add(8);
        olhaList.add(10);
       //System.out.println(olhaList.contains(8));
        olhaList.remove(10);
        olhaList.print();*/


        // Task 5
        UserTreeSet myTree;
        myTree.add("Olha", 5);
        myTree.add("Helen", 7);
        myTree.add("Irina", 3);
        myTree.add("Natalia", 15);

        myTree.print();

        // Task 1
        /*int a[] = new int[] {2,6,8,10,20,45,90};
        System.out.println(binarySearch(a ,900));*/

    }
}
