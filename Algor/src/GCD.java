/*
 * Michael Hadzopulos
 * Dr. Lynn
 * Algorithms - Tues/Thurs 4-5:15
 */


import java.util.ArrayList;
import java.util.Random;

public class GCD 
{
	static int maxIteration = 0;
	static int lowIteration = 10000;
	static ArrayList<Integer> avgit = new ArrayList<Integer>();
	static int maxm, maxn, maxans, leastm, leastn, leastans;
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		for(int i = 0; i < 100; i++)
		{
			int pair1 = rand.nextInt(19000) + 1000;
			int pair2 = rand.nextInt(19000) + 1000;
			CIC(pair1, pair2);
		}
		printAns();
		System.out.println("");
		resetOutput();
		avgit.clear();
		
		for(int i = 0; i < 100; i++)
		{
			int pair1 = rand.nextInt(19000) + 1000;
			int pair2 = rand.nextInt(19000) + 1000;
			Euclid(pair1, pair2);
		}
		printAns();
		
	}
	
	public static void CIC(int m, int n)
	{	int t;
		boolean found = false;
		boolean step4 = false;
		int counter = 0;
		if(m > n)
			t = n;
		else
			t = m;
	
		while(found != true)
		{
			step4 = false;
			int r = m%t;
		
			if(r == 0)
			{
				r = n%t;
				if(r == 0)
				{
					found = true;
					avgit.add(counter);
					
					if(counter > maxIteration)
					{
						maxIteration = counter;
						maxm = m;
						maxn = n;
						maxans = t;
					}
					if(counter < lowIteration)
					{
						lowIteration = counter;
						leastm = m;
						leastn = n;
						leastans = t;
					}
					
				}
				else if(r != 0)
				{
					t--;
					counter++;
					step4 = true;
				}
				
			}
			else if(r != 0 && step4 == false)
			{
				t--;
				counter++;
			}
		}
		
	}
	
	public static void Euclid(int m, int n)
	{	
		int counter = 0;
		int r, om, on;
		if(m > n)
		{
			r = m%n;
			om = m;
			on = n;
		}
		else
		{
			r= n%m;
			om= n;
			on = m;
		}
		if(r == 0)
		{
			avgit.add(counter);
			if(counter > maxIteration)
			{
				maxIteration = counter;
				maxm = m;
				maxn = n;
				maxans = r;
			}
			if(counter < lowIteration)
			{
				lowIteration = counter;
				leastm = m;
				leastn = n;
				leastans = r;
			}
		}
		else
		{
			counter++;
			Euclid(on, r, counter, om, on);
			
		}
	}

public static void Euclid(int m, int n, int c, int o, int p)
{	
	int counter = c;
	int r;
	r = m%n;
	if(r == 0)
	{
		avgit.add(counter);
		if(counter > maxIteration)
		{
			maxIteration = counter;
			maxm = o;
			maxn = p;
			maxans = n;
		}
		if(counter < lowIteration)
		{
			lowIteration = counter;
			leastm = o;
			leastn = p;
			leastans = n;
		}
	}
	else
	{
		counter++;
		Euclid(n, r, counter, o, p);
		
	}
}
	public static void resetOutput()
	{
		maxIteration = 0;
		lowIteration = 10000;
		avgit.clear();
		maxm = 0;
		maxn = 0;
		maxans = 0;
		leastm = 0;
		leastn = 0;
		leastans = 0;
	}
	public static void printAns()
	{
		int sum = 0;
		System.out.println("The most iterations used is " + maxIteration +
				" for GCD(" + maxm + "," + maxn + ") = " + maxans);
		System.out.println("The least iterations used is " + lowIteration +
				" for GCD(" + leastm + "," + leastn + ") = " + leastans);
		
		for(Integer i: avgit)
		{
			sum = sum+i;
		}
		int average = sum/avgit.size();
		System.out.println("The average number used for 100 iteration pairs is " + average);
	}
}
