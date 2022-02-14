package relampagorojo93.LibsCollection.SpigotThreads;

import java.util.ArrayList;
import java.util.List;

import relampagorojo93.LibsCollection.SpigotThreads.Objects.Thread;

public class ThreadManager {
	private List<Thread> threads = new ArrayList<>();
	public Thread registerThread(Thread.Runnable runnable) {
		return this.registerThread(runnable, null);
	}
	public Thread registerThread(Thread.Runnable runnable, Thread.CallBack callback) {
		return this.registerThread(new Thread(runnable, callback));
	}
	public Thread registerThread(Thread thread) {
		return threads.add(thread) ? thread : null;
	}
	public void unregisterThread(Thread thread) {
		this.unregisterThread(thread.getId());
	}
	public void unregisterThread(long threadid) {
		for (Thread thread:threads) {
			if (thread.getId() == threadid) {
				try {
					thread.stop();
				} catch (Exception e) {}
				threads.remove(thread);
				break;
			}
		}
	}
	public void unregisterThreads() {
		for (Thread thread:threads)
			try {
				thread.stop();
			} catch (Exception e) {}
		threads.clear();
	}
}
