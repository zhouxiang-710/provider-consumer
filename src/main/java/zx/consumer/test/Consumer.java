package zx.consumer.test;

/**
 * @ Author     ：zhouxiang.
 * @ Date       ：Created in 20:34 2020/12/9
 * @ Description：消费者
 * @ Modified By：
 * @Version: $version$
 */
public class Consumer implements Runnable {
    private ResourcePool letter;

    public Consumer(ResourcePool s) {
        letter = s;
    }

    public void run() {
        char ch;
        for (int i = 0; i < 100; i++) {
            ch = letter.resourceDel();
            //消费资源
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}