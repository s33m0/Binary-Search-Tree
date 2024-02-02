
public class Main {

    public static void main(String[] args) {
        BST bst=new BST();

        for (int i = 1; i <=100 ; i++) {
            bst.add(i);
        }

           bst.search(100);
            bst.remove(100);
            bst.printPostOrder();
    }
}