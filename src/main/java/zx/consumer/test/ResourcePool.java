package zx.consumer.test;

/**
 * @ Author     ：zhouxiang.
 * @ Date       ：Created in 20:32 2020/12/9
 * @ Description：资源池
 * @ Modified By：
 * @Version: $version$
 */
public class ResourcePool {
    private int index = 0;
    private int capicity = 100;
    // 共享数据资源池
    private char[] data;

    public ResourcePool(int capicity) {
        System.out.println("创建资源池");
        this.capicity = capicity;
        data = new char[capicity];
    }

    /**
     * 生产资源
     */
    public synchronized void resourceAdd(char c) {
        while (index == capicity) {
            try {
                System.err.println("资源池已满");
                this.wait();// 等待，直到有数据出栈
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        data[index] = c;
        index++;
        System.out.println("生产者生产了资源:" + c);
        this.notify();// 通知其它线程把数据出栈
    }

    /**
     * 消费资源
     */
    public synchronized char resourceDel() {
        while (index == 0) {
            try {
                System.err.println("资源池已经空了");
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        index--;
        char ch = data[index];
        System.out.println("消费者消费了字母:" + ch);
        this.notify(); // 通知其它线程把数据入栈
        return ch;
    }
}