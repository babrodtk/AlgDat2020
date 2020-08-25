public class BTNode {

    public static class Node {
        Node parent;
        Node left_child;
        Node right_child;
        char value;

        public Node(Node parent, char value) {
            this.parent = parent;
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        void addLeftChild(char value) {
            this.left_child = new Node(this, value);
        }

        void addRightChild(char value) {
            this.right_child = new Node(this, value);
        }

        void print() {
            System.out.println(this.value);
            if (this.left_child != null) {
                this.left_child.print();
            }
            if (this.right_child != null) {
                this.right_child.print();
            }
        }

        Node grandParent() {
            return this.parent.parent;
        }
    }

    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        Node root = new Node(null, a[0]);
        root.addLeftChild(a[1]);
        root.addRightChild(a[2]);

        root.left_child.addLeftChild(a[3]);
        root.left_child.addRightChild(a[4]);

        root.right_child.addLeftChild(a[5]);
        root.right_child.addRightChild(a[6]);

        System.out.println("Printing binary tree!");
        //Why do we print it in this order?
        root.print();
    }
}
