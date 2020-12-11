package zx.consumer.wait_sleep;

import java.util.LinkedList;

public class QueueWithWait<T> extends BlockingQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();
	private final int cacheSize;

	public QueueWithWait(int cacheSize) {
		super();
		this.cacheSize = cacheSize;
	}

	public T take() {
		synchronized (queue) {
			while(true) {
				if(queue.size()>0) {
					T obj = queue.poll();
					queue.notify();
					return obj;
				}else {
					try {
						queue.wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}

	public void put(T obj) {

		synchronized (queue) {
			while (true) {
				if (queue.size() < cacheSize) {
					queue.offer(obj);
					queue.notify();
					break;
				} else {
					try {
						queue.wait();
					} catch (InterruptedException e) {
					}
				}

			}
		}

	}

}
