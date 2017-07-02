package com.org.set2;

import java.util.Scanner;

public class MurderMystery {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	String s="1";
	String temp="";
	int cur=0;
	int count=1;
	String res="";
	int noOfCharacters=0;
	
	//Getting the Nth line of puzzle
	
	for(int i=2;i<=n;i++)
	{
		
		for(int j=0;j<s.length();j++)
		{
	
		if(s.charAt(j)==' ')
		{
			
			int c=Integer.parseInt(temp);
			if(c==cur)
				count++;
			
			else if(cur==0)
			{
				cur=c;
				count=1;
			}
			
			else
			{
				res+=count+" "+cur;
				if(j!=s.length()-1)
					res+=" ";
				cur=c;
				count=1;
			}
			
			temp="";
		}
		else{
			temp+=s.charAt(j);
		}
			
		}
		//System.out.println(res);
		if(!temp.isEmpty())
		{
			if(Integer.parseInt(temp)==cur)
			{
			count++;
			res+=count+" "+cur;
			}
			else if(cur==0)
			{
				res+=1+" "+temp;
				
			}
			else{
				res+=count+" "+cur+" "+1+" "+temp;
			}
			
		}
		
		s=res;
		res="";
		count=1;
		cur=0;
		temp="";
	
	}
		
	//count the number of characters
	for(int i=0;i<s.length();i++)
		if(s.charAt(i)!=' ')
			noOfCharacters++;
	
	//printing the answer
	System.out.println(noOfCharacters);
	obj.close();
	
}
}
