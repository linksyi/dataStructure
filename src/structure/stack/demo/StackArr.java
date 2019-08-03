package structure.stack.demo;

/**
 * @author My.ZuoY
 * @date 2019-08-02 19:08
 * 用数组实现栈
 */
public class StackArr<T> {
    private T[] data;
    private int maxSize;
    private final int defaultSize = 10;
    private int top = -1;

    public StackArr(){
        maxSize = defaultSize;
        data = (T[]) new Object[defaultSize];
    }
    public StackArr(int size){
        if(size < 0){
            throw new RuntimeException("参数有误");
        }
        maxSize = size;
        data = (T[]) new Object[size];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isFull(){
        return top == -1;
    }
    /**
     * 判断栈是已满
     * @return
     */
    private boolean isEmpty(){
        return top == maxSize -1;
    }

    /**
     * 给栈添加元素
     * @param item
     */
    public void add(T item){
        if(isEmpty()){
            System.out.println("栈已满");
            return;
        }
        data[++top] = item;
    }

    /**
     * 获取栈元素
     * @return
     */
    public T get(){
        T item = data[top];
        data[top--] = null;
        return item;
    }

    /**
     * 打印栈所有元素
     */
    public void printAll(){
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }

    /**
     * 返回栈长度
     * @return
     */
    public int size(){
        return top + 1;
    }
}
