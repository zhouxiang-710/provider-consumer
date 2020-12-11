package zx.consumer.wait_sleep;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue= new QueueWithWait<>(1000);
		//生产者线程
		new Thread() {
			public void run() {
				while(true) {
					queue.put(String.valueOf(System.currentTimeMillis()));
				}
			}
		}.start();

		//消费者线程
		new Thread() {
			public void run() {
				long start = System.currentTimeMillis();
				long count=0;
				long lastCount=0;
				while(true) {
					queue.take();
					count++;
					long now = System.currentTimeMillis();
					if(now-start>=1000) {
						System.out.println("每秒获取记录数："+(count-lastCount)+"个");
						start=now;
						lastCount=count;
					}
				}
			}
		}.start();

	}

}
