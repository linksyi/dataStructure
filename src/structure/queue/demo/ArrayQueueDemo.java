package structure.queue.demo;

import java.util.Arrays;

/**
 *  通过数组实现循环列表
 * @author: Mr.ZuoY
 * @create: 2018-7-20
 **/
public class ArrayQueueDemo<T> {
    private int maxSize;
    private final int defaultSize = 5;
    private int front;
    private int rear;
    private T[] dataArr;

    /**
     * 使用默认长度初始化队列
     */
    public ArrayQueueDemo() {
        maxSize = defaultSize;
        dataArr = (T[]) new Object[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 给队列手动赋值长度
     */
    public ArrayQueueDemo(int size) {
        if (size < 1) {
            throw new RuntimeException("参数有误");
        }
        maxSize = size;
        dataArr = (T[]) new Object[size];
        front = -1;
        rear = -1;
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
        return rear + 1 == maxSize;
    }

    /**
     * 队列扩容，每次扩容队列长度的一半
     */
    public void expansion() {
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
        return dataArr[++front];
    }

    /**
     * 获取队列数据
     *
     * @param data
     */
    public void add(T data) {
        if (isEmpty()) {
            expansion();
//            throw new RuntimeException("队列数据已满，不可存储数据");
        }
        dataArr[++rear] = data;
    }

    public void printQueue() {
        if (isNull()) {
            System.out.println("队列为空，无需打印");
            return;
        }
        for (int i = (front + 1); i <= rear; i++) {
            System.out.println(dataArr[i]);
        }
    }
}
