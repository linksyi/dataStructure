package structure.linkedList.Demo;

/**
 * @author: Mr.ZuoY
 * @create: 2019-07-26 09:01
 * 双向链表
 **/
public class DoubleLinkedListDemo<T> {
    Node<T> front;
    Node<T> next;
    private static class Node<T> {
        private T data;
        private Node<T> front;
        private Node<T> next;
    }

    /**
     * 添加
     * @param data
     */
    public void add (T data){
        if(next == null){
            next = new Node<T>();
            next.data = data;
            return ;
        }
        Node<T> item = next;
        while (true){
            if (item.next == null){
                Node<T> newNode = new Node<>();
                newNode.data = data;
                newNode.front = item;
                item.next = newNode;
                break;
            }
            item = item.next;
        }
    }

    public void printlnAll() {
        Node<T> item = next;
        while (true) {
            if (next == null) {
                System.err.println("链表为空");
                break;
            }

            if (item == null) {
                System.out.println("循环完毕");
                break;
            } else {
                System.out.println(item.data);
            }
            item = item.next;
        }
    }
}
