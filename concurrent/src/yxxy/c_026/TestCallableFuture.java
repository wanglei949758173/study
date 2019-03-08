/**      
 * 模块编号  
 * 功能描述 
 * 文件名 CallableFuture.java  
 * 作者 王磊 
 * 编写日期 2018年7月18日    
 */
package yxxy.c_026;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableFuture {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		Task task = new Task();
		
		Future<Integer> result = threadPool.submit(task);
		
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

class Task implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算....");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
	}
	
}
