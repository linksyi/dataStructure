package structure.hashtable.demo;

/**
 * @author My.ZuoY
 * @date 2019-08-28 17:02
 * 哈希表(散列表实现)
 */
public class HashTableDome<K, V> {
    private final int DEFAULT_SIZE = 10;
    private int size;
    private Node[] nodeArr;

    /**
     * 初始化
     */
    public HashTableDome() {
        this.size = this.DEFAULT_SIZE;
        nodeArr = new Node[size];
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new Node<V>();
        }
    }

    /**
     * 初始化
     */
    HashTableDome(int size) {
        this.size = size;
        nodeArr = new Node[size];
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new Node<V>();
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode() % size;
        Node node = nodeArr[index];
        if (node.data == null) {
            node.data = value;
            return;
        }
        Node item = node;
        while (true) {
            if (item.next == null) {
                item.next = new Node(value);
                break;
            }
            item = item.next;
        }
    }

    public void list() {
        for (int i = 0; i < nodeArr.length; i++) {
            Node node = nodeArr[i];
            while (true) {
                if (node.data == null) {
                    break;
                }
                System.out.println(node.data.toString());
                if (node.next == null) {
                    break;
                }
                node = node.next;
            }
        }
    }
}

class Node<V> {
    public V data;
    public Node next;

    Node(V data) {
        this.data = data;
    }

    Node() {
    }
}