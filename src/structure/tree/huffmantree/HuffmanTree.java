package structure.tree.huffmantree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author My.ZuoY
 * @date 2019-09-06 11:25
 * 霍夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = huffmanTree.huffmanTree(arr);
        huffmanTree.preOrder(node);
    }

    public void preOrder(Node node) {
        if (node == null) {
            System.out.println("无法遍历null节点");
        } else {
            node.preOrder();
        }
    }

    /**
     * 构建霍夫曼树
     * @param arr 传入霍夫曼树数组对象
     */
    public Node huffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        nodes.sort(Node::compareTo);
        while(nodes.size() > 1){
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node node = new Node(leftNode.value + rightNode.value);
            node.left = leftNode;
            node.right = rightNode;
            nodes.add(node);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.sort(Node::compareTo);
        }
        return nodes.get(0);
    }

    private static class Node implements Comparable<Node>{
        int value;
        Node left;
        Node right;

        private void preOrder() {
            System.out.println(this);
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        Node(int value) {
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
