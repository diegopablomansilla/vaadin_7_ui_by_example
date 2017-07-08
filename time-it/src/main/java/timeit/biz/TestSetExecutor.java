package timeit.biz;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public class TestSetExecutor {
	
	public static Collection<String> execute(TestSet testSet, long times) {
		ArrayList<String> results = new ArrayList<String>();
		
		testSet.init();
		
		for(Test test : testSet.getTests()) {
			long time = execute(test, times);
			results.add(test.getName() + ": " + time + " ms.");
		}
		
		return results;
	}
	
	public static long execute(Test test, long times) {
		long startTime = System.nanoTime();
		
		for(long i = 0; i < times; i++) {
			test.execute();
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000000;
	}

}
