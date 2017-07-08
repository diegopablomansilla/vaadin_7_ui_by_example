package timeit.biz;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public interface TestSet {
	
	Test[] getTests();
	
	void init();
	
	long getDefaultTimes();
	
	String getTitle();

	String getDescription();
	
}
