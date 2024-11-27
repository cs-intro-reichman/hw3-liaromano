// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    System.out.println ("Tests some of the operations"); 
	     System.out.println(plus(-5,-3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-3,4));  // 3 * 4
   		 System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		 System.out.println(pow(3,5));      // 3^5
   		 System.out.println(div(12,3));   // 12 / 3    
   		 System.out.println(div(5,5));    // 5 / 5  
   		 System.out.println(div(25,7));   // 25 / 7
   		 System.out.println(mod(25,7));   // 25 % 7
   		 System.out.println(mod(120,6));  // 120 % 6    
   		 System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		if(x2>0)
		{
			while(x2!=0)
			{
				x2--;
				x1++;
			}
		}
		else if(x2<0)
		{
			while(x2!=0)
			{
				x2++;
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if(x2>0)
		{
			while(x2!=0)
			{
				x2--;
				x1--;
			}
		}
			else if(x2<0)
			{
				while(x2!=0)
				{
					x2++;
					x1++;
				}
			}
			
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int xr=0;
		boolean negative= false;
		if((x1==0)|| (x2==0))
		{
			return 0;
		}
		else if ((x1>0 && x2<0)|| (x1<0 && x2>0))
		{
			negative=true;

		}
		x1= Math.abs(x1);
		x2=Math.abs(x2);
		for(int i=0;i<x2;i++)
		{
			xr=plus(xr,x1);
		}
		if(negative)
		{
			xr=minus(0,xr);
		}
			return xr;
	}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int s=1;
		for(int i=0;i<n;i++)
		{
			s=times(s,x);
		}
		return s;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int count=0;
		if(x1>=x2)
		{
			while(x1>=x2)
		{
			x1=minus(x1,x2);
			count++;
		}
	}
	if(x1<0 && x2<0)
	{
		x1= times(x1,-1);
		x2= times(x2,-1);
		if(x1>=x2)
		{
			while(x1>=x2)
		{
			x1=minus(x1,x2);
			count++;
		}
	}
	}
	if(x1<0 && x2>0)
	{
		x1= times(x1,-1);
		if(x1>=x2)
		{
			while(x1>=x2)
		{
			x1=minus(x1,x2);
			count++;
		}
		count= times(count,-1);
	}
	if(x1>0 && x2<0)
	{
		x2= times(x2,-1);
		if(x1>=x2)
		{
			while(x1>=x2)
		{
			x1=minus(x1,x2);
			count++;
		}
		count= times(count,-1);
	}
}
}return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
			while(x1 >= x2)
		{
			x1=minus(x1,x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		if(x<0)
		{
			return -1;
		}
		int i=0;
		int check=0;
		while(check<x)
		{
			check= pow(i,2);
			i++;
		}
		if(x==0)
		{
			return 0;
		}
		if((pow((i-1),2)>x))
		{
			return i-2;
		}
		return i-1;
	}
	}	  	