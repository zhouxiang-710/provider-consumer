package zx.consumer.wait_sleep;

import java.util.LinkedList;

public class QueueWithSleep<T> extends BlockingQueue<T> {

	private LinkedList<T> queue = new LinkedList<>();
	private final int cacheSize;

	public QueueWithSleep(int cacheSize) {
		super();
		this.cacheSize = cacheSize;
	}

	public T take() {
		while (true) {
			synchronized (queue) {
				if (queue.size() > 0) {
					T obj = queue.poll();
					return obj;
				} else {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}

	public void put(T obj) {
		while (true) {
			synchronized (queue) {
				if (queue.size() < cacheSize) {
					queue.offer(obj);
					break;
				} else {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}

			}
		}

	}

}
