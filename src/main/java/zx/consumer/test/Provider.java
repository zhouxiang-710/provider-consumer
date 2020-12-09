package zx.consumer.test;

/**
 * @ Author     ：zhouxiang.
 * @ Date       ：Created in 20:33 2020/12/9
 * @ Description：生产者
 * @ Modified By：
 * @Version: $version$
 */
public class Provider implements Runnable {
    private ResourcePool letter;

    public Provider(ResourcePool s) {
        letter = s;
    }

    public void run() {
        char ch;
        for (int i = 0; i < 100; i++) {
            // 随机生成字母
            ch = (char) (Math.random() * 26 + 'A');
            letter.resourceAdd(ch);
            try {
                // 生产者随机休眠
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}