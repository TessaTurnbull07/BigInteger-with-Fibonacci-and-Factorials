//Thessalonica Turnbull
//Spring 2023 Advanced Java
//HW - Factorial, using BigInteger
//Created February 21, 2023
//
//displays the factorial for a number a user inputs
//bigintegers only
//(works up to 11500 in recursion)
//(works up to 57000 in for loop)

import java.math.BigInteger;
import java.util.Scanner;

public class Turnbull_FacHomeworkBIGINT {
	public static void main (String [] args){
	    long input = 0;
	    
	    if ( args.length == 1 ){
	       input = Integer.parseInt(args[0]);
	    }
	    else{
	       Scanner s = new Scanner(System.in);
	       System.out.print("Please enter value: ");
	       input = s.nextInt();
	       
	       s.close();
	    }

	    //changes long input into BigInt
	    BigInteger val = BigInteger.ZERO;
	    val = BigInteger.valueOf(input);
	    
	    //send to for loop
	    long t1 = System.currentTimeMillis();
	    System.out.println(val + "! = " + factorial_loop(val) );
	    long t2 = System.currentTimeMillis();
	    System.out.println("For loop elapsed time: " + (t2-t1) / 1000. + " seconds");
	    BigInteger v = factorial_loop(val);
	    System.out.println("Length of the number: " + v.toString().length());
	    
	    //send to recursion
//	    t1 = System.currentTimeMillis();
//	    System.out.println(val + "! = " + factorial_recursive(val) );
//	    t2 = System.currentTimeMillis();
//	    System.out.println("Recursion elapsed time: " + (t2-t1) / 1000. + " seconds");
	  }

	//uses a for loop to get factorials
	public static BigInteger factorial_loop(BigInteger n){
	    BigInteger result = BigInteger.ONE;
	    if (n.compareTo(BigInteger.ONE) > 0) {
	      for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 1; i = i.add(BigInteger.ONE)) {
	    	 result = result.multiply(i);
	      }
	    }
	    return result;
	  }
		
	//uses a recursive loop to get factorials
	public static BigInteger factorial_recursive(BigInteger n){
		BigInteger result = BigInteger.ONE;
	    if (n.compareTo(BigInteger.ONE)> 0) {
	    	result = n.multiply(factorial_recursive(n.subtract(BigInteger.ONE)));
	    }
	    return result;
	}
}
