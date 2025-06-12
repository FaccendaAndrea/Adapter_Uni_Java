package myTest;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestResult;
import junit.framework.TestListener;
import junit.framework.AssertionFailedError;

/**
 * Test runner class for the ListAdapter project.
 * This class runs all test cases and provides a detailed summary of results.
 */
public class TestRunner implements TestListener {
    private int testCount = 0;
    private int failureCount = 0;
    private int errorCount = 0;
    private long startTime;
    private String currentTest = "";

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.run();
    }

    public void run() {
        System.out.println("Starting ListAdapter Test Suite\n");
        startTime = System.currentTimeMillis();

        TestSuite suite = new TestSuite();
        suite.addTestSuite(ListAdapterTest.class);

        TestResult result = new TestResult();
        result.addListener(this);
        suite.run(result);

        long endTime = System.currentTimeMillis();
        double executionTime = (endTime - startTime) / 1000.0;

        System.out.println("\n=== Test Execution Summary ===");
        System.out.println("Total Tests Run: " + testCount);
        System.out.println("Tests Passed: " + (testCount - failureCount - errorCount));
        System.out.println("Tests Failed: " + failureCount);
        System.out.println("Tests with Errors: " + errorCount);
        System.out.println("Execution Time: " + executionTime + " seconds");
    }

    public void addError(Test test, Throwable t) {
        errorCount++;
        System.out.println("Test " + currentTest + ": ERROR");
        System.out.println("\t" + t.getMessage());
    }

    public void addFailure(Test test, AssertionFailedError t) {
        failureCount++;
        System.out.println("Test " + currentTest + ": FAILED");
        System.out.println("\t" + t.getMessage());
    }

    public void endTest(Test test) {
        if (failureCount == 0 && errorCount == 0) {
            System.out.println("Test " + currentTest + ": COMPLETED");
        }
    }

    public void startTest(Test test) {
        testCount++;
        currentTest = test.toString().replace("test", "Test ");
        System.out.println("\nExecuting " + currentTest + "...");
    }
} 