class TreeNode implements Comparable<TreeNode> {

    private int value;

    private TreeNode pNode;
    private TreeNode lNode;
    private TreeNode rNode;

    TreeNode (int x){
        value = x;
    }

    TreeNode (TreeNode x){
        pNode = x.pNode;
        lNode = x.
    }

    void setParent(TreeNode x){
        pNode = x;
    }

    void setLeft(TreeNode x){
        lNode = x;
    }

    void setRight(TreeNode x){
        rNode = x;
    }

    /*public TreeNode getNext(){
        return next;
    }*/

    public int getData(){
        return value;
    }

    @Override
    public int compareTo(TreeNode node){
        return Integer.compare(this.value, node.value);
    }
}

public class UserTreeSet {

    TreeNode root;

    private static int size;

    boolean add(Comparable element){
        // first element adding
        if(root == null)
            root = new TreeNode(element);
        else {
            TreeNode newNode = new TreeNode(element);

            //add logic

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
}
