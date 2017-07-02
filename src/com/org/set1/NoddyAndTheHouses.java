package com.org.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class House{
private int houseNo;
private int position;

public House(int h,int p)
{
	houseNo=h;
	position=p;
}

public int getHouseNumber()
{
	return houseNo;
}

public int getPosition()
{
	return position;
}

}

public class NoddyAndTheHouses {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	House arr[]=new House[n];
	
	for(int i=0;i<n;i++)
	{
		int hi=obj.nextInt();
		int pi=obj.nextInt();
		arr[i]=new House(hi,pi);
	}
	
	//declaring a comparator for sorting operation
	Comparator<House> c=new Comparator<House>()
			{
		
		     public int compare(House a,House b)
		     {
		    	 if(a.getPosition()<b.getPosition())
		    	 {
		    		 return -1;
		    	 }
		    	 else
		    		 return 1;
		    	 
		     }
		
			};
	
			//sorting the array
	Arrays.sort(arr,c);
	
	//find the maximum possible plot
	
	int max=Integer.MIN_VALUE;
	int h1=-1;
	int h2=-1;
	
	for(int i=1;i<n;i++)
	{
		if(arr[i].getPosition()-arr[i-1].getPosition()>max)
		{
			max=arr[i].getPosition()-arr[i-1].getPosition();
			h1=arr[i-1].getHouseNumber();
			h2=arr[i].getHouseNumber();
		}
	}
	
	System.out.println(max+"\n"+(h1<h2?h1+" "+h2:h2+" "+h1));
	obj.close();
	
}
}
