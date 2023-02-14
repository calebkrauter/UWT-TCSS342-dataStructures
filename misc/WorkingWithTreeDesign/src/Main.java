public class Main {
    public static void main(String[] args) {
        Node node= new Node();

        System.out.println( node.recursiveNode(100));
    }

}

// Is this actually a tree with roots that have multiple children?
class Node {
    public Node recursiveNode(int x) {
        x--;
        if (x == 0) {
            return null;
        }
        if (x % 2 == 0) {
            System.out.println(x + " Left");
            return recursiveNode(x);
        } else {
            System.out.println(x + " Right");
            return recursiveNode(x);
        }
    }
}