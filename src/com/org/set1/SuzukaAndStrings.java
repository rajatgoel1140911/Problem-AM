package com.org.set1;

import java.util.Arrays;
import java.util.Scanner;

public class SuzukaAndStrings {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	int q=obj.nextInt();
	String s=obj.next();
	int hash[]=new int[26];
	
	//building the hash array
	for(int i=0;i<s.length();i++)
		hash[s.charAt(i)-97]++;
	
	//queries input
	for(int i=1;i<=q;i++)
	{
		char c=obj.next().charAt(0);
		hash[c-97]=hash[c-97]!=0?hash[c-97]-1:hash[c-97];
		String p=findLongestPal(hash);
		System.out.println(p);
	}
	
	obj.close();
	
}

static String findLongestPal(int hash[])
{
	
	String front="";
	String rear="";
	boolean isOdd=false;
	char c=' ';
	
	for(int i=0;i<hash.length;i++)
	{
		int a=hash[i];
	  while(a>1)
	  {
		  front+=(char)(i+97);
		  rear=(char)(i+97)+rear;
		  a-=2;
	  }
		if(a==1)
		{
			isOdd=true;
			c=(char)(i+97);
		}
	}
	
	return isOdd?front+c+rear:front+rear;
	
}


}
