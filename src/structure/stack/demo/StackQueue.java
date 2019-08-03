package structure.stack.demo;

/**
 * @author My.ZuoY
 * @date 2019-08-02 22:18
 * 用队列实现栈
 */
public class StackQueue<T> {
    private Node<T> next;

    private class Node<T>{
        private T item;
        private Node<T> next;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    private boolean isFull(){
        return next == null;
    }

    /**
     * 添加数据
     * @param data 元素
     */
    public void add(T data){
        if(isFull()){
            next = new Node<T>();
            next.item = data;
            return ;
        }
        Node node = new Node<T>();
        node.item = data;
        node.next = next;
        next = node;
    }

    /**
     * 获取数据
     * @return
     */
    public T get(){
        if(isFull()){
            throw new RuntimeException("暂无数据");
        }
        T item = next.item;
        this.next = next.next;
        return item;
    }

    /**
     * 打印栈中所有数据
     */
    public void printAll(){
        if(isFull()){
            return;
        }
        Node<T> node = next;
        while (true){
            System.out.println(node.item);
            if(node.next == null){
                break;
            }else{
                node = node.next;
            }
        }
    }

    /**
     * 获取栈长度
     * @return
     */
    public int size(){
        int num = 0;
        if(isFull()){
            return num;
        }

        Node<T> node = next;
        while (true){
            num++;
            if(node.next == null){
                break;
            }else{
                node = node.next;
            }
        }
        return num;
    }
}
