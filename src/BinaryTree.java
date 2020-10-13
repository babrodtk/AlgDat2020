import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class BinaryTree {

    static class BinaryTreeNode {
        char value;
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        BinaryTreeNode(char value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        BinaryTreeNode addLeftChild(char value) {
            this.left_child = new BinaryTreeNode(value);
            return this.left_child;
        }

        BinaryTreeNode addRightChild(char value) {
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }
    }

    static void printLevelOrder(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

        //legg til rot-noden
        queue.addLast(root);

        while (!queue.isEmpty()) {
            //1. Ta ut første fra køen
            BinaryTreeNode current = queue.removeFirst();

            //2. Legg til current sine to barn til køen
            if (current.left_child != null) {
                queue.addLast(current.left_child);
            }
            if (current.right_child != null) {
                queue.addLast(current.right_child);
            }

            //3. Skriv ut
            System.out.println(current.value + " ");
        }
    }

    static void printPreOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        printPreOrder(node.left_child);
        printPreOrder(node.right_child);
    }


    static void printInOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left_child);
        System.out.print(node.value + " ");
        printInOrder(node.right_child);
    }


    static void printPostOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.left_child);
        printPostOrder(node.right_child);
        System.out.print(node.value + " ");
    }

    static void printPreOrderNonRecursive(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();

        stack.addLast(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.removeLast();

            if (current.right_child != null) {
                stack.addLast(current.right_child);
            }
            if (current.left_child != null) {
                stack.addLast(current.left_child);
            }

            System.out.print(current.value + " ");
        }
    }

    public static void main(String[] args) {
        //Lager rot-noden (nivå 0)
        BinaryTreeNode root = new BinaryTreeNode('A');

        //Legg inn resterende noder på nivå 1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        //Legg inn alle noder på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        //Kall funksjonen vår.
        //printLevelOrder(root);
        System.out.println("Pre order:");
        printPreOrder(root);
        System.out.println();

        System.out.println("In order:");
        printInOrder(root);
        System.out.println();

        System.out.println("Post order:");
        printPostOrder(root);
        System.out.println();

        System.out.println("Pre order non-recursive:");
        printPreOrderNonRecursive(root);
        System.out.println();
    }
}
