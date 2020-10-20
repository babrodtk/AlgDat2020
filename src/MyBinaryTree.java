public class MyBinaryTree {

    static class Node {
        char value;
        Node left_child;
        Node right_child;
        Node parent;

        Node(char value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.left_child = null;
            this.right_child = null;
        }

        static void insert(Node current, char value) {
            //Rekursiv funksjon:
            //1. kalle seg selv
            //2. forenkle argumentene
            //3. ende i et basistilfelle

            if (value >= current.value) {
                if (current.right_child == null) {
                    current.right_child = new Node(value, current);
                }
                else {
                    insert(current.right_child, value);
                }
            }
            else {
                if (current.left_child == null) {
                    current.left_child = new Node(value, current);
                }
                else {
                    insert(current.left_child, value);
                }
            }
        }

        void printPreorder() {
            //Skrive ut
            System.out.print(this.value + ", ");

            //Rekursivt gå til venstre
            if (this.left_child != null) {
                this.left_child.printPreorder();
            }

            //rekursivt gå til høyre
            if (this.right_child != null) {
                this.right_child.printPreorder();
            }
        }

        static Node nextPreorder(Node p) {
            //Venstre barn finnes
            if (p.left_child != null) {
                return p.left_child;
            }
            //Venstre barn finnes ikke, men vi har høyre barn
            else if (p.right_child != null) {
                return p.right_child;
            }
            //Vi har ingen barn
            else {
                Node current = p.parent;
                while (current != null && current.right_child == p) {
                    current = current.parent;
                    p = p.parent;
                }
                //VI har et høyre barn som er søsken av p, det er neste preorden
                if (current
                        != null) {
                    return current.right_child;
                }
                //Vi kommer hele tiden fra høyre, dvs vi er siste pre orden
                else {
                    return null;
                }

            }
        }
    }

    public static void main(String[]args) {

        Node root = new Node('M', null);

        Node.insert(root, 'D');
        Node.insert(root, 'P');
        Node.insert(root, 'C');
        Node.insert(root, 'E');
        Node.insert(root, 'N');
        Node.insert(root, 'Q');
        Node.insert(root, 'F');
        Node.insert(root, 'O');

        root.printPreorder();

        System.out.println();
        Node current = root;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = Node.nextPreorder(current);
        }
    }


}
