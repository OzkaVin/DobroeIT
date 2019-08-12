package task5;

/*�������: new new new new new olga

1) �������� �������� ��������� ������:
int binarySearch(int [] data, int element); <- ���� ������� element � data, ���������� ������ �������� ��������, ��� � ������ ����������: -1. ������ data ������� ��� ���������������.

2) ������� ����� UserLinkedList. ����� ������ ��������� ������:
boolean add(Object element) <- ���������� � ����� ������.
boolean contains(Object element) <- �������� �� �������.
int size() <- ���������� ������ ������.
boolean isEmpty() <- ���������� true, ���� ������ ������.
boolean remove(Object element) <- �������� ��������.

3) �������� ���� ����� � ������ UserLinkedList.

4) �������� ���������� ��������� ������ ������, UserTreeSet. ����� ������ ��������� ������:
boolean add(Object element) <- ���������� � ����� ������.
boolean contains(Object element) <- �������� �� �������.
int size() <- ���������� ������ ������.
boolean isEmpty() <- ���������� true, ���� ������ ������.
boolean remove(Object element) <- �������� ��������.

5) �������� ����� ������ void print(), ������� ����������� ��� �������� �� ������ � ��������������� ����.

6) �������� ������ ��� ������ ������������| ������������� �������� �� ������.

7) * ��� ���������� �������� ������ ������������ ���������. ����� ��������� ����� �� � Object, � � ���������� ����� T.

����������:
https://rutracker.org/forum/viewtopic.php?t=3286611

������ �������:
https://www.khanacademy.org/com�/computer-science/algorithms*/

public class TaskFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {2,15,27,35,50,62,78,89,96,110};
		
		System.out.println(binarySearch(array, 9));

	}
	
	public static int binarySearch(int [] data, int element){
		
		int mid = data.length/2 - 1;
		int first = 0, last = data.length - 1;
		
		while ((data[mid] != element) && (first <= last)) {
            if (data[mid] > element) {  // ���� ����� ��������� ��� ������
                last = mid - 1; // ��������� ������� �� 1.
            } else {
                first = mid + 1;    // ����� ����������� �� 1
            }
            mid = (first + last) / 2;
        }
		if (first <= last) 
			return ++mid;		
		else return -1;
	}
	
	
	
	public static class UserLinkedList<T> {
		//Comparable<E>> implements Comparable<E>
	    private Node<T> first;    // beginning of queue
	    private Node<T> last;     // end of queue
	    private int n;               // number of elements on queue
  
	    // helper linked list class
	    public static class Node<T> {
	        private T item;
	        private Node<T> next;
	        private Node<T> previous;
	    }

	   public UserLinkedList() {
	        first = null;
	        last  = null;
	        n = 0;
	    }
	   
	   public boolean isEmpty() {
	        return first == null;
	    }
	   
	   public int size() {
	        return n;
	    }
	   
	   public void add(T item) {
	        Node<T> oldlast = last;
	        
	        last = new Node<T>();
	        last.item = item;
	        last.next = null;
	        last.previous = oldlast;
	        
	        if (isEmpty()) 
	        	first = last;
	        else           
	        	oldlast.next = last;
	        n++;
	    }
	   
	   boolean contains(T item){ //<- �������� �� �������.
		    Node<T> current = first;
		    
			while (current.item != item){
				if (current != last)
					current = current.next;
				else 
					return false;
			}
			return true;
	   }
	   
	   boolean remove(T item){ //<- �������� ��������.
		   Node<T> current = first;
		    
			while (current.item != item){
				if (current != last)
					current = current.next;
				else 
					return false;
			}
			
			// deleting current
			current.previous.next = current.next;
			current.next.previous = current.previous;
			n--;
			
			return true;
	   }
	}
	
	// TODO
	// ������������ UserLinkedList
	public class UserLinkedListTest{
		private UserLinkedList <Integer> intList;
		
		@Before
		public void init(){
			intList = new UserLinkedList<Integer>();
		}
		
		@Test
		
	}
	
	
	
	//�������� ���������� ��������� ������ ������, UserTreeSet. 
	public static class UserTreeSet<T extends Comparable<T>>{
		Node<T> root;
		private int n;
		
	    private static class Node<T extends Comparable<T>> {
	           	
	    	private T item;
	    	private Node<T> left;
	        private Node<T> right;
	        
	        public int compareTo(Node<T> other)
	        {
	            return item.compareTo(other.item);
	        }
	        
	        public Node(T nodeData) {
	            item = nodeData;
	            left = right = null; // node has no children
	        }	    
	    
		    /*public void insert(T insertValue) {
		        // insert in left subtree
		        if (item.compareTo(insertValue) > 0) {
		            // insert new TreeNode
		            if (left == null)
		                left = new Node<T>(insertValue);
		            else // continue traversing left subtree
		                left.insert(insertValue);
		        } // end if
		        else if (item.compareTo(insertValue) < 0) // insert in right subtree
		        {
		            // insert new TreeNode
		            if (right == null)
		                right = new Node<T>(insertValue);
		            else // continue traversing right subtree
		                right.insert(insertValue);
		        } 
		    }*/
		    
		    public Node<T> insert( Node<T> node, T insertValue )
		    {
		        if (node == null)
		        	return new Node<T>( insertValue );
		        
		        if ( item.compareTo(insertValue) > 0 ) 
		        	node.left = insert( node.left, insertValue ); 
		        else 
		        	if ( item.compareTo(insertValue) < 0 )
		        		node.right = insert( node.right, insertValue );
		        return node;
		    }
		    
		    pu
	    }
	    
	    public void add(T insertValue )
	    {
	        root.insert( root, insertValue );
	    }
				    
	    boolean contains (T item){
	    	return root.contains(item);
	    }
	    
	    
	    
	    
	    
	    private boolean contains (Node<T> root, T item){
	    	if(root == null)
		    	return false;
		    
		    if(root.item == item)
		    	return true;
		    
		    if(root.compareTo(item)==1)
		    	return contains(root.r, item);
		    else
		    	return contains(root.l, item);
	    }

	    
	    Node<T> search(Node<T> t, int key) {
	        if (t == null || t.key == key)
	            return t;
	        if (key < t.key)
	            return search(t.l, key);
	        else
	            return search(t.r, key);
	    }
	    
	    public Node<T> search(int key) {
	        return search(root, key);
	    }
	    
	       
	    void replace(Node a, Node b) {
	        if (a.p == null)
	            root = b;
	        else if (a == a.p.l)
	            a.p.l = b;
	        else
	            a.p.r = b;
	        if (b != null)
	            b.p = a.p;
	    }
	    
	    void remove(Node t, int key) {
	        if (t == null)
	            return;
	        if (key < t.key)
	            remove(t.l, key);
	        else if (key > t.key)
	            remove(t.r, key);
	        else if (t.l != null && t.r != null) {
	            Node m = t.r;
	            while (m.l != null)
	                m = m.l;
	            t.key = m.key;
	            t.value = m.value;
	            replace(m, m.r);
	        } else if (t.l != null) {
	            replace(t, t.l);
	        } else if (t.r != null) {
	            replace(t, t.r);
	        } else {
	            replace(t, null);
	        }
	    }
	    
	    public void remove(int key) {
	        remove(root, key);
	    }
	    
	    void print(Node t) {
	        if (t != null) {
	            print(t.l);
	            System.out.print(t.key + ":" + t.value + " ");
	            print(t.r);
	        }
	    }
	    
	    public void print() {
	        print(root);
	        System.out.println();
	    }
		
		/*
		
		boolean contains(Object element){ //<- �������� �� �������.
			
		}
		
		int size(){ //<- ���������� ������ ������.
			
		}
		
		boolean isEmpty(){// <- ���������� true, ���� ������ ������.
			
		}
		
		boolean remove(Object element){// <- �������� ��������.
			
		}*/

		//5) �������� ����� ������ void print(), ������� ����������� ��� �������� �� ������ � ��������������� ����.

		//6) �������� ������ ��� ������ ������������| ������������� �������� �� ������.
	
	}
     
}
