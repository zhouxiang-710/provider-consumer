package zx.consumer.wait_sleep;

public abstract class BlockingQueue<T> {
	public abstract T take() ;
	public abstract void put(T obj);
}
