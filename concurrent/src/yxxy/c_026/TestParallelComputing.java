/**      
 * 模块编号  
 * 功能描述 
 * 文件名 TestParallelComputing.java  
 * 作者 王磊 
 * 编写日期 2018年7月18日    
 */
package yxxy.c_026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("all")
public class TestParallelComputing {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		List<Integer> results = getPrime(1, 200000);
		long end = System.currentTimeMillis();
		System.out.println("串行计算所花费的时间:" + (end - start));
		
		final int cpuNum = 4;// Runtime.getRuntime().availableProcessors()
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		
		Future<List<Integer>> result1 = threadPool.submit(new MyTask(1, 100000));
		Future<List<Integer>> result2 = threadPool.submit(new MyTask(100000, 150000));
		Future<List<Integer>> result3 = threadPool.submit(new MyTask(150000, 185000));
		Future<List<Integer>> result4 = threadPool.submit(new MyTask(185000, 200000));
		
		start = System.currentTimeMillis();
		result1.get();
		result2.get();
		result3.get();
		result4.get();
		end = System.currentTimeMillis();
		System.out.println("并行计算所花费的时间:" + (end - start));
	}
	
	
	static class MyTask implements Callable<List<Integer>> {
		private int start;
		private int end;
		public MyTask(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public List<Integer> call() throws Exception {
			return getPrime(start, end);
		}
		
	}
	
	static boolean isPrime(Integer num) {
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	static List<Integer> getPrime(int start, int end) {
		List<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		return list;
	}
}

