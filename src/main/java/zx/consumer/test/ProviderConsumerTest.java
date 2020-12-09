package zx.consumer.test;

/**
 * @ Author     ：zhouxiang.
 * @ Date       ：Created in 20:34 2020/12/9
 * @ Description：资源消费测试
 * @ Modified By：
 * @Version: $version$
 */
public class ProviderConsumerTest {
    public static void main(String[] args) {
        ResourcePool letter = new ResourcePool(5);
        Runnable provider = new Provider(letter);
        Runnable consumer = new Consumer(letter);

        Thread p1 = new Thread(provider);
        Thread c2 = new Thread(consumer);
        p1.start();
        c2.start();
    }
}