//Thessalonica Turnbull
//Spring 2023 Advanced Java
//HW - Fibonacci, using a For Loop and Recursion, with Memoization, with BigInteger
//Created February 21, 2023
//
//prompts or takes user input and displays the value of that fibonacci number

import java.math.BigInteger;
import java.util.Scanner;

public class Turnbull_FibHomeworkMemoBIGINT {
	public static BigInteger[] theMemo;
	
	public static void main (String [] args){
	    int input = 0;
	    if ( args.length == 1 ){
	       input = Integer.parseInt(args[0]);
	    }
	    else{
	       Scanner s = new Scanner(System.in);
	       System.out.print("Please enter value: ");
	       input = s.nextInt();
	       
	       s.close();
	    }
	    BigInteger val = BigInteger.valueOf(input);
	    
	    //sends to for loop
	    long t1 = System.currentTimeMillis();
	    theMemo = new BigInteger [val.intValue() + 1];
	    
	    BigInteger result = fibonacci_loop(val);
	    System.out.println("Fib(" + val + ") = " + result);
	    
	    long t2 = System.currentTimeMillis();
	    System.out.println("For loop elapsed time: " + (t2-t1) / 1000. + " seconds");
	  }

//	//uses a for loop to get fibonacci numbers
//	public static BigInteger fibonacci_loop(BigInteger f){
//		BigInteger result = BigInteger.ONE;
//		if (f.compareTo(BigInteger.ONE) > 0 ) {
//			BigInteger a = BigInteger.ONE;
//			BigInteger b = BigInteger.ONE;
//			for(int count = 3; count <= f.intValue(); count++) {
//			 result = a.add(b);
//	         a = b;
//	         b = result;
//		    }
//	      }
//	    return result;
//	  }
	
	//users a for loop with memoization to get fibonacci numbers
	public static BigInteger fibonacci_loop(BigInteger f){
	    BigInteger[] theMemo = new BigInteger[f.intValue() + 1];
	    theMemo[0] = BigInteger.ZERO;
	    theMemo[1] = BigInteger.ONE;

	    for (int i = 2; i <= f.intValue(); i++) {
	        theMemo[i] = theMemo[i-1].add(theMemo[i-2]);
	    }

	    return theMemo[f.intValue()];
	}
	
//	//uses a recursion to get fibonacci numbers
//	public static BigInteger fibonacci_recursive(BigInteger f){
//	    BigInteger result = BigInteger.ONE;
//	    if (f.compareTo(BigInteger.valueOf(2)) > 0) {
//	    	if (theMemo[f.intValue()] != null) {
//	    		result = theMemo[f.intValue()];
//	    	} else {
//	    		result = fibonacci_recursive(f.subtract(BigInteger.ONE)).add(fibonacci_recursive(f.subtract(BigInteger.valueOf(2)))); 
//	    		theMemo[f.intValue()] = result;
//	    	}
//	    }
//	    return result;
//	  }
}
