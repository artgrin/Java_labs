import java.util.Scanner;
import java.lang.Math;

public class Program {
   
	private static boolean is_prime(Long n) {
	    long i = 3;
	    while (i < Math.sqrt(n)) {
	        if (n % i == 0) return false;
	        i += 2;
	    }
	    return true;
	}
	
	private static void part1(long num)
	{
		System.out.println("bin: " + Long.toBinaryString(num));
        System.out.println("oct: " + Long.toOctalString(num));
        System.out.println("hex: " + Long.toHexString(num));
	}
	
	private static void part2(long num)
	{
		long p = 1, n = 2;
		if(num == 0) num = 2305843008139952128l;
	    while (p * n < num) { //while (p * n < (4 * n - 1) * 2 * n)
	        p = 2 * n - 1;
	        if (is_prime(p))
	        	{
	        		System.out.println(Long.toString(n*p));
	        	}
	        n <<= 1;
	    }
	}
	
    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        Long num = in.nextLong();
        while(num < 0)
        {
        	System.out.print("You must input a positive number: ");
        	num = in.nextLong();
        }
        part1(num);
        part2(num);
                
        in.close();
    }
}