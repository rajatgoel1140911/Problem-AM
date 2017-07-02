package com.org.samples;

import java.util.Scanner;

public class mazeQuestion {
	
	static int min=Integer.MAX_VALUE;
	static String path="";
	
public static void main(String[] args) {

	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	int m=obj.nextInt();
	
	//initial energy
	int e=obj.nextInt();
	int sr=obj.nextInt();
	int sc=obj.nextInt();
	obj.nextLine();
	char mat[][]=new char[n+1][m+1];
	
	
	
	for(int i=1;i<=n;i++)
	{
		String s=obj.nextLine();
		for(int j=1;j<=m;j++)
		{
			mat[i][j]=s.charAt(j-1);
		}
		
	}
	
	
	int energy[][]=new int[n+1][m+1];
	
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=m;j++)
		{
			energy[i][j]=obj.nextInt();
		}
	}
				
	//built the matrix
	
	//solving using BACKTRACKING
	backtrack(e,0,sr,sc,n,m,energy,"",mat);
	if(min!=Integer.MAX_VALUE)
	System.out.println(min+"\n"+path);
	
	else
		System.out.println("-1");
}

static void backtrack(int e,int d,int i,int j,int n,int m,int energy[][],String s,char mat[][])
{
	
	if(i<1||i>n||j<1||j>m||mat[i][j]=='#')
		return;
	
	s=s+"("+i+","+j+") ";
	
	if(i==n&&j==m)
	{
		if(min>d)
		{
			min=d;
			path=s;
		}
	}
	
	e+=energy[i][j];
	
	if(e==0)
		return;
		
	//down
	
	backtrack(e-1,d+1,i+1,j,n,m,energy,s,mat);
	
	//right
	
	backtrack(e-1,d+1,i,j+1,n,m,energy,s,mat);
	
}

}
