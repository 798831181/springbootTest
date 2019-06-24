package zssf;

public class SussersorNode {
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getLeftMost(Node node){
        if (node == null)
            return null;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
    public static Node getSuccessorNode(Node node){
        if (node == null)
            return null;
        if (node.right != null){//存在右子树
            return getLeftMost(node);
        }else {//不存在右子树
            Node parent = node.parent;
            while (node != parent.left && parent != null){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
