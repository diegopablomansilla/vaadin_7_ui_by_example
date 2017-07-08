package timeit.biz.test;

import timeit.biz.Test;
import timeit.biz.TestSet;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public class ShortCircuitVsNoShortCircuit implements TestSet {
	
	private double i;
	
	public class ShortCircuitTest implements Test {
		@Override
		public String getName() {
			return "if(i < 100 && i > 50)";
		}
		
		@Override
		public void execute() {
			if(i < 100 && i > 50) {
				i++;
				System.out.println(i);
			}
		}
	}

	public class NoShortCircuitTest implements Test {
		@Override
		public String getName() {
			return "if(i < 100 & i > 50)";
		}
		
		@Override
		public void execute() {
			if(i < 100 & i > 50) {
				i++;
				System.out.println(i);
			}
		}
	}
	
	@Override
	public Test[] getTests() {
		return new Test[] { new ShortCircuitTest(), new NoShortCircuitTest() };
	}

	@Override
	public void init() {
		i = 0;
	}
	
	@Override
	public long getDefaultTimes() {
		return 200000000;
	}
	
	@Override
	public String getTitle() {
		return "&& vs &";
	}
	
	@Override
	public String getDescription() {
		return "This will test the difference between short-circuiting && and not short-circuiting &.";
	}

}
