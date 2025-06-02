package myTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test runner class for the ListAdapter project.
 * This class runs all test cases and provides a summary of results.
 */
public class TestRunner {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(ListAdapterTest.class);
        
        junit.textui.TestRunner runner = new junit.textui.TestRunner();
        runner.doRun(suite);
    }
} 