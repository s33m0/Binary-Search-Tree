public class BST {
    Node root;

    // Method to recursively add a new node to the binary search tree
    public void addRec(Node start, Node newNode){
        if(root==null){
            root=newNode;
            return;
        }

        if(newNode.value> start.value){
            if( start.right==null)
                start.right=newNode;
            addRec(start.right,newNode);
        }
        if(newNode.value< start.value){
            if( start.left==null)
                start.left=newNode;
            addRec(start.left,newNode);
        }

    }
    // Public method to add a new value to the binary search tree
    public void add(int value){
        Node newNode=new Node(value);
        addRec(root,newNode);
    }

    public void search(int value){
       SearchRec(value,root);

    }
//    private boolean containsNodeRecursive(Node current, int value) {
//        if (current == null) {
//            return false;
//        }
//        if (value == current.value) {
//            return true;
//        }
//        return value < current.value
//                ? containsNodeRecursive(current.left, value)
//                : containsNodeRecursive(current.right, value);
//    }


// Private method to recursively search for a value in the binary search tree
    private void SearchRec(int value, Node start){
        if(start==null){
            System.out.println("The tree is empty!");
            return;
        }
        if(start.value==value)
        {
            System.out.println("The element is found");
        }
        if( value>start.value){
            SearchRec(value, start.right);
        }
        if( value<start.value){
            SearchRec(value, start.left);
        }
    }
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    public void remove(int value){
        deleteRecursive(root,value);
    }

    public void printInOrder(){
        inorderRec(root);
    }
    public void printPreOrder(){traversePreOrder(root);}
    public void printPostOrder(){traversePostOrder(root);}

    private void inorderRec(Node root) {
        if (root!=null){
            inorderRec(root.left);
            System.out.print(root.value+" ");
            inorderRec(root.right);
        }
    }
    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
}
