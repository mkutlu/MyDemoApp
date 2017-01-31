package com.mycompany.app;
import java.lang.Math;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
	public static int greatestCommonDivisor(int a, int b, int c)
	{
            int limit;
 	    limit = Math.min(a, b);
    	    limit = Math.min(limit, c);
    	    for(int n = limit; n >= 2; n--)
    	    {
       		 if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
           	    return n;
       	    	 }
            }
	    return 1;
	}
}
