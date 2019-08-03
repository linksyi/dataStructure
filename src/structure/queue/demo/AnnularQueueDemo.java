package structure.queue.demo;

import java.util.Arrays;

/**
 * 通过数组实现简单列表
 * @author: Mr.ZuoY
 * @create: 2018-7-20
 **/
public class AnnularQueueDemo<T> {
    private int maxSize;
    private final int defaultSize = 5;
    private int front;
    private int rear;
    private T[] dataArr;

    /**
     * 使用默认长度初始化队列
     */
    public AnnularQueueDemo() {
        maxSize = defaultSize;
        dataArr = (T[]) new Object[maxSize];
    }

    /**
     * 给队列手动赋值长度
     */
    public AnnularQueueDemo(int size) {
        if (size < 1) {
            throw new RuntimeException("参数有误");
        }
        maxSize = size;
        dataArr = (T[]) new Object[size];
    }

    /**
     * 判断队列是否为空队列
     *
     * @return
     */
    public boolean isNull() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isEmpty() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 队列扩容，每次扩容队列长度的一半
     */
    private void expansion() {
        maxSize += maxSize >> 1;
        dataArr = Arrays.copyOf(dataArr, maxSize);
    }

    /**
     * 获取队列数据
     *
     * @return
     */
    public T getdata() {
        if (isNull()) {
            throw new RuntimeException("队列数据为空，不可获取数据");
        }
        T data = dataArr[front];
        front = (front + 1) % maxSize;
        return data;
    }

    /**
     * 添加队列数据
     *
     * @param data
     */
    public void add(T data) {
        if (isEmpty()) {
            expansion();
//            throw new RuntimeException("队列数据已满，不可存储数据");
        }
        dataArr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    public int size() {
//        (rear + maxSize -front) % maxSize
        int abs = Math.abs(rear - front);
        if (rear == 0 || front == 0) {
            abs -= 1;
        } else {
            abs += 1;
        }
        return abs;
    }

    public void printQueue() {
        if (isNull()) {
            System.out.println("队列为空，无需打印");
            return;
        }
        System.out.println("front" + front);
        System.out.println("rear" + rear);
        System.out.println(size());
        for (int i = front; i < front + size(); i++) {
            int index = i % maxSize;
            System.out.println(dataArr[index]);
        }
    }
}
