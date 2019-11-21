import java.util.List;
import java.util.Objects;

public class Main {

    public static class Friend implements Comparable<Friend> {
        private String name;
        private int ID;

        public void setData(String setName, int setID) {
            name = setName;
            ID = setID;
        }

        @Override
        public int compareTo(Friend friend) {
            return Integer.compare(this.ID, friend.ID);
        }

       /* public int getValue() {
            return ID;
        }*/
    }


    public static class ListNode {

        private Object element;
        private ListNode next;

        ListNode (Object o){
            element = o;
        }

        ListNode (ListNode nextNode, Object o){
            element = o;
            next = nextNode;
        }

        public ListNode getNext(){
            return this.next;
        }

        public Object getData() {
            return element;
         }
    }


    public static class UserSortedList {

        private ListNode first;

        ListNode getRoot() {
            return first;
        }

        private static int size;

        /*ListNode insertSearch(Comparable o){
            do {
                if ((curr.getNext()).getData() == element){

                    curr.setNext((curr.getNext()).getNext());
                    return true;
                }
                curr = curr.getNext();
            } while (curr != null);
        }*/


        // if both elements equals!!!
        public void add(Object o) {
            // first element adding
            if(first == null)
                first = new ListNode(o);
            else {
                ListNode curr = first;

                ListNode newNode = new ListNode (o);

                //comparing first one
                if ((curr.getData()).compareTo(o) > 1){



                    newNode.next = first;
                    first = newNode;
                    size++;
                    return;
                }

                ListNode nextNode = curr.getNext();

                while (nextNode != null) {
                    if ((curr.getData()).compareTo(o) < 1){

                        curr.next = newNode;
                        newNode.next = nextNode;
                        size++;
                        return;
                    }
                    curr = curr.getNext();
                    nextNode = curr.getNext();
                }

                //we are on last element
                //inserting after it
                curr.next = newNode;
                size++;
            }
            return;
        }




       /* boolean contains(Comparable element) {
            if (element == null ||)

        if x == null or k == x.key
        return x
        if k < x.key
        return search(x.left, k)
   else
        return search(x.right, k)
        }*/

        //boolean UserTreeSet contains()


        public void remove() {
            size--;
        }


        public void print() {
            if (size > 0)
                print(first);
        }

        private void print(ListNode element) {
            while (element != null) {
                System.out.println(element.getData());
                element = element.getNext();
            }


            /*if (element != null)
                print(element.getLeftNode());
            System.out.println((element.getParent()).getData());

            if (element.getRightNode() != null)
                print(element.getRightNode());
            System.out.println((element.getParent()).getData());*/
        }


        public int size() {
            return size;
        }


        public boolean isEmpty() {
            if (size == 0) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        // Task 5
        /*UserTreeSet myTree;
        myTree.add("Olha", 5);
        myTree.add("Helen", 7);
        myTree.add("Irina", 3);
        myTree.add("Natalia", 15);

        myTree.print();*/


    }
}
