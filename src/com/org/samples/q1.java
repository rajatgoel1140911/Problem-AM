package com.org.samples;
import java.util.Arrays;
import java.util.Scanner;


public class q1 {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	
	int K=obj.nextInt();//amount of clay
	int N=obj.nextInt();//no. of items
	
	int A[]=new int[N];//amounts array
	int P[]=new int[N];//profits array
	
	//taking the amounts
	for(int i=0;i<N;i++)
		A[i]=obj.nextInt();
	
	
	//input profits
	for(int i=0;i<N;i++)
	    P[i]=obj.nextInt();
	
	
	//final answer quantities
	 int quan[]=new int[N];
	 
	 
	 //basic
	 if(N==0||K==0)
	 {
		 System.out.println(0);
		 for(int i=0;i<N;i++)
			 System.out.print(quan[i]+" ");
	 }
	 else{
		
		 long mat[][]=new long[N+1][K+1];
		 for(int i=1;i<=N;i++)
		 {
			 for(int j=1;j<=K;j++)
			 {
				 if(A[i-1]>j)
				 {
					 mat[i][j]=mat[i-1][j];
				 }
				 else{
				 mat[i][j]=Math.max(mat[i-1][j],P[i-1]+mat[i][j-A[i-1]]);
				 }
				 
			 }
		 }
		 
		 
		 System.out.println(mat[N][K]);
		//building the result
		 
		 int i=N-1;
		 int row=N;
		 int col=K;
		 
		 while(true)
		 {
		    if(mat[row][col]==mat[row-1][col])
		    {
		    	row=row-1;
		    	i--;
		    }
		    else{
		    	quan[i]++;
		    	col=col-A[i];
		    }
			
		    if(row==0||col==0)
		    	break;
		    
		 }
		 
		 //printing the result
		for(int p=0;p<quan.length;p++)
		{
			System.out.print(quan[p]+" ");
		}
	 }
	
	
	
}
}
