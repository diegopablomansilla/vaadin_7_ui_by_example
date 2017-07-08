package timeit.biz.test;

import timeit.biz.Test;
import timeit.biz.TestSet;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public class StringVsStringBuffer implements TestSet {
	
	private static final String ADD_THIS = "a";
	
	@SuppressWarnings("unused")
	private String s;
	private StringBuffer sb;
	
	public class StringTest implements Test {

		@Override
		public String getName() {
			return "String";
		}

		@Override
		public void execute() {
			s += "a";
		}
	}

	public class StringBufferTest implements Test {

		@Override
		public String getName() {
			return "StringBuffer";
		}

		@Override
		public void execute() {
			sb.append(ADD_THIS);
		}
	}

	@Override
	public Test[] getTests() {
		return new Test[] {new StringTest(), new StringBufferTest()};
	}

	@Override
	public void init() {
		s = "";
		sb = new StringBuffer();
	}

	@Override
	public long getDefaultTimes() {
		return 100000;
	}

	@Override
	public String getTitle() {
		return "String vs StringBuffer";
	}

	@Override
	public String getDescription() {
		return "How much do we gain by using StringBuffer instead of String when dealing with strings?";
	}

}
