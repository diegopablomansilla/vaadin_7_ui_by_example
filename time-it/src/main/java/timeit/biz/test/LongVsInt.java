package timeit.biz.test;

import timeit.biz.Test;
import timeit.biz.TestSet;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public class LongVsInt implements TestSet {
	
	private int iterations;
	
	public class LongTest implements Test {
		long i;
		
		@Override
		public String getName() {
			return "for(long i...";
		}
		
		@Override
		public void execute() {
			for(i = 0; i < iterations; i++);
		}
	}

	public class IntTest implements Test {
		int i;
		
		@Override
		public String getName() {
			return "for(int i...";
		}
		
		@Override
		public void execute() {
			for(i = 0; i < iterations; i++);
		}
	}

	@Override
	public Test[] getTests() {
		return new Test[] {new LongTest(), new IntTest()};
	}

	@Override
	public void init() {
		iterations = 100000;
	}

	@Override
	public long getDefaultTimes() {
		return 10000;
	}

	@Override
	public String getTitle() {
		return "long vs int loop";
	}

	@Override
	public String getDescription() {
		return "One could think a loop controlled by an int is faster than one controlled by a long. Let's check how much the difference is.";
	}
}
