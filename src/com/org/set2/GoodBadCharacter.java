package com.org.set2;

import java.util.HashMap;
import java.util.Scanner;

public class GoodBadCharacter {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	int k=obj.nextInt();
	String s=obj.next();
	
	int left[]=new int[26];
	int right[]=new int[26];
	
	for(int i=0;i<k&&i<n;i++)
	{
		right[s.charAt(i)-97]++;
	}
	
	int curc=0;
	int remleft=0;
	int incright=k;
	int good=0;
	
	while(curc<n)
	{
	   int pos=s.charAt(curc)+1;
	   pos=(pos>122?0:pos-97);
	   right[s.charAt(curc)-97]--;
	   
	   if(incright<n)
	   right[s.charAt(incright)-97]=(incright<n?right[s.charAt(incright)-97]+1:right[s.charAt(incright)-97]);
	   
	   if(right[pos]==0&&left[pos]==0)
	   {
		   good++;
	   }
	   
	   left[s.charAt(curc)-97]++;
	   right[s.charAt(curc)-97]--;
	   if(remleft==curc-k-1)
	   {
		   left[s.charAt(remleft++)-97]--;
	   }
	   
	   if(incright<=n)
	   incright++;
	   curc++;
	   
	}
	
	System.out.println(good);
	
}
}
