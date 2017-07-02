package com.org.set1;

import java.util.Scanner;

public class CouncilChief {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	//X^n=a*b*c*d.......
	//nlog(x)=log(a)+log(b)+log(c)+.....
	int n=obj.nextInt();
	double logRight=0;
	for(int i=1;i<=n;i++)
	{
		int a=obj.nextInt();
		logRight+=Math.log(a);
	}
	
	//divide by n
	logRight/=n;
	
	//this given log(x)=logRight
	
	long answer=(long)Math.ceil(Math.pow(Math.E,logRight));
	System.out.println(answer);
	//check for 1 2 3 4 5
	//answer should be 3
	
	obj.close();
	
}
}
