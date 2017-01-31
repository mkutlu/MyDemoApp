package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

   public void testFound() {
      assertEquals(2,new App().greatestCommonDivisor(2,4,6));
    }

    public void testSameElement() {
      assertEquals(4,new App().greatestCommonDivisor(4,4,4));
    }

    public void testNoGCD() {
       assertEquals(1,new App().greatestCommonDivisor(2,3,4));
    }

    public void testAnother() {
      assertEquals(1,new App().greatestCommonDivisor(3,5,7));
    }
    public void testAnotherOne() {
      assertEquals(4,new App().greatestCommonDivisor(16,8,12));
    }
}
