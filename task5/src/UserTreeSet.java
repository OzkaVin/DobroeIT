public class Main {

    class NodeData {
        private String name;
        private int ID;

        public void setNodeData(String setName, int setID) {
            name = setName;
            ID = setID;
        }

        public int getValue() {
            return ID;
        }
    }

    class TreeNode implements Comparable<TreeNode> {

        private NodeData nData;

        private TreeNode pNode;
        private TreeNode lNode;
        private TreeNode rNode;

        public TreeNode(String setName, int setID) {
            nData.setNodeData(setName, setID);
        }

        TreeNode(TreeNode x) {
            pNode = x.pNode;
            lNode = x.lNode;
            rNode = x.rNode;
        }

        void setParent(TreeNode x) {
            pNode = x;
        }

        void setLeft(TreeNode x) {
            lNode = x;
        }

        void setRight(TreeNode x) {
            rNode = x;
        }

        TreeNode getLeftNode() {
            return lNode;
        }

        TreeNode getRightNode() {
            return rNode;
        }

        TreeNode getParent() {
            return pNode;
        }

    /*public TreeNode getNext(){
        return next;
    }*/

        public NodeData getData() {
            return nData;
        }

        @Override
        public int compareTo(TreeNode node) {
            return Integer.compare(this.getData().getValue(), node.getData().getValue());
        }
    }

    public class UserTreeSet {

        private static TreeNode root;

        TreeNode getRoot() {
            return root;
        }

        private static int size;


        public void UserTreeSet

        add(String Name, int ID) {
            TreeNode newNode = new TreeNode(Name, ID);

            // first element adding
            if (getRoot() == null) {
                root = newNode;
                size++;
            } else {
                this.add(this.getRoot(), newNode);
            }
        }

        private void UserTreeSet

        add(Comparable rootNode, Comparable node) {
            //add logic
            if (node < rootNode)
                rootNode.setLeft(add(rootNode.getLeftNode(), node));
            else if (node > rootNode)
                rootNode.setRight(add(rootNode.getRightNode(), node));
            size++;
        }


        boolean UserTreeSet contains(Comparable element) {
            if (element == null ||)

        /*if x == null or k == x.key
        return x
        if k < x.key
        return search(x.left, k)
   else
        return search(x.right, k)*/
        }

        //boolean UserTreeSet contains()


        void UserTreeSet

        remove() {

            size--;
        }


        public void print() {
            if (size > 0)
                print(root);
        }

        private void print(Comparable element) {
            if (element != null)
                print(element.getLeftNode());
            print(element.getParent().getData());

            if (element.getRightNode != null)
                print(element.getRightNode());
            print(element.getParent().getData());
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
        UserTreeSet myTree;
        myTree.add("Olha", 5);
        myTree.add("Helen", 7);
        myTree.add("Irina", 3);
        myTree.add("Natalia", 15);

        myTree.print();
    }
}
