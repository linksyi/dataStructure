package structure.linkedList.Demo;

/**
 * 单列表，带列表头
 *
 * @author: Mr.ZuoY
 * @create: 2019-07-21 20:08
 **/
public class SingleChainDemo<T> {
    public Node<T> next;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T item) {
            data = item;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public void add(T newNode) {
        Node item = next;
        while (true) {
            if (item == null) {
                next = new Node<T>(newNode);
                break;
            }
            if (item.next == null) {
                item.next = new Node<>(newNode);
                break;
            }
            item = item.next;
        }
    }

    /**
     * 打印整个单链
     */
    public void printlnAll() {
        Node item = next;
        while (true) {
            if (next == null) {
                System.out.println("链表为空");
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

    /**
     * 判断单链是否为空
     */
    public boolean isEmpty() {
        return next == null;
    }

    /**
     * 返回单链表长度
     *
     * @return
     */
    public int size() {
        int num = 0;
        Node item = next;
        while (true) {
            if (next == null || item == null) {
                break;
            }
            num++;
            item = item.next;
        }
        return num;
    }

    /**
     * 清空链表
     */
    public void clear() {
        next = null;
    }

    /**
     * 寻找第N个节点
     * index下标从0开始
     */
    public T getByIndex(int index) {
        T data = null;
        int num = 0;
        Node<T> item = next;
        while (true) {
            if (next == null || item == null) {
                break;
            }
            if (num == index) {
                data = item.data;
                break;
            }
            num++;
            item = item.next;
        }
        return data;
    }

    /**
     * 获取倒数第N个节点
     * @param index 倒数下标从1开始
     * @return
     */
    public T getByInvertedIndex(int index) {
        int size = size();
        if (size < index) {
            return null;
        }
        return getByIndex(size - index);
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public Node<T> Reversal(Node<T> head){
        //如果只有两个节点则没必要反转
        if(head == null || head.next == null){
            return head;
        }
        Node<T> newHead = Reversal(head.next);
        // 将当前结点的指针域指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域令为null;
        head.setNext(null);
        // 反转后新链表的头结点
        next = newHead;
        return newHead;
    }
}
