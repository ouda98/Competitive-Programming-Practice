package CP_9_18_LowestCommonAncestor;

public class Implemntation {
    static boolean v1;
    static boolean v2;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        v1 = false;
        v2 = false;
        Node lca = findLCA(root,1,1);
        if (v1 && v2)
            System.out.println(lca.val);
        else
            System.out.println("ONE node is missing");


    }

    private static Node findLCA(Node node, int n1, int n2) {
        if(node == null)
            return null;
        Node temp = null;
        if(node.val == n1){
            v1 =true;
            temp = node;
        }
        if(node.val == n2){
            v2 =true;
            temp = node;
        }

        Node left = findLCA(node.left, n1,n2);
        Node right = findLCA(node.right,n1,n2);
        if(temp!=null)
            return temp;
        if(left!=null && right!=null)
            return node;

        if(left!=null)
            return left;
        else
            return right;
    }

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
}
