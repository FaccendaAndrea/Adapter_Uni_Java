package myTest;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Test runner class that executes all test cases and reports results.
 * 
 * Template: Homework
 * Assignment: Implement an adapter for List interface
 * Course: Software Development Methods
 */
public class AdapterTestRunner {
    /**
     * Creates a test suite containing all test cases.
     *
     * @return the test suite
     */
    public static Test suite() {
        TestSuite suite = new TestSuite("ListAdapter Tests");
        suite.addTestSuite(ListAdapterTest.class);
        return suite;
    }

    /**
     * Main method to run the test suite from command line.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Running ListAdapter tests...\n");
        long startTime = System.currentTimeMillis();
        
        TestRunner.run(suite());
        
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.println("\nTotal time: " + totalTime + " ms");
    }
} 